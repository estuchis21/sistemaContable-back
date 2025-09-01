package sistemacontable.back.DAO;

import java.math.BigDecimal;
import sistemacontable.back.Interfaces.LibroDiarioI;
import sistemacontable.back.Models.Asientos;
import sistemacontable.back.Models.Operaciones;
import sistemacontable.back.ConnectionDB;

import java.sql.*;
import java.time.LocalDateTime;

public class LibroDiarioDAO implements LibroDiarioI {

    // -------------------------------
    // Seleccionar asiento por ID
    // -------------------------------
    @Override
    public Asientos selectAsientoPorId(int id_asiento) {
        String sql = "{call selectAsientoPorId(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id_asiento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Asientos asiento = new Asientos();
                asiento.setId_asiento(rs.getInt("id_asiento"));
                asiento.setDescripcion(rs.getString("descripcion"));
                Timestamp ts = rs.getTimestamp("fecha_asiento");
                if (ts != null) {
                    asiento.setFecha_asiento(ts.toLocalDateTime());
                }
                return asiento;
            }

        } catch (Exception e) {
            System.err.println("Error selectAsientoPorId: " + e.getMessage());
        }
        return null;
    }

    // -------------------------------
    // Crear asiento y obtener su ID
    // -------------------------------
    @Override
    public boolean generarAsiento(Asientos asiento) {
        String sql = "{call sp_insertar_asiento(?)}";
        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, asiento.getDescripcion());

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                asiento.setId_asiento(rs.getInt("id_asiento"));
                return true;
            }

        } catch(Exception e){
            System.err.println("Error generarAsiento: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean generarOperacionPorAsiento(Operaciones op) {
        String sql = "{call insertarOpsEnAsientos(?,?,?,?,?,?,?,?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, op.getId_asiento());
            stmt.setInt(2, op.getId_cuenta());
            stmt.setInt(3, op.getId_tipo_movimiento());
            stmt.setBigDecimal(4, java.math.BigDecimal.valueOf(op.getMonto()));
            stmt.setString(5, op.getTipoLibro()); // obligatorio, no null
            stmt.setBoolean(6, op.isIva21());
            stmt.setBoolean(7, op.isIva105());
            stmt.registerOutParameter(8, Types.INTEGER);

            stmt.execute();
            op.setId_operacion(stmt.getInt(8));

            System.out.println("Operación insertada correctamente, id_operacion=" + op.getId_operacion());
            return true;

        } catch (SQLException e) {
            System.err.println("=== ERROR SQL AL GENERAR OPERACION ===");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Código error: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());
            return false;
        } catch (Exception e) {
            System.err.println("=== ERROR INESPERADO AL GENERAR OPERACION ===");
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean existeAsiento(int id_asiento) {
        String sql = "{call ExisteAsiento(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id_asiento);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.err.println("Error existeAsiento: " + e.getMessage());
        }
        return false;
    }
}
