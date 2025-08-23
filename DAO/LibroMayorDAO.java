/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.DAO;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import sistemacontable.back.ConnectionDB;
import sistemacontable.back.Interfaces.LibroMayorI;
import sistemacontable.back.Models.LibroMayor;

/**
 *
 * @author Esteban
 */
public class LibroMayorDAO implements LibroMayorI {

    @Override
    public List<LibroMayor> getLibroMayor(int idCuenta) {
        String sql = "{call libroMayor(?)}";
        List<LibroMayor> libro = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCuenta);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LibroMayor lm = new LibroMayor(
                    rs.getInt("id_asiento"),
                    rs.getTimestamp("fecha_asiento") != null ? rs.getTimestamp("fecha_asiento").toLocalDateTime() : null,
                    rs.getString("descripcion"),
                    rs.getInt("id_tipo_movimiento"),
                    rs.getString("tipo_saldo"),
                    rs.getDouble("saldo_acumulado")
                );
                libro.add(lm);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener el libro mayor: " + e.getMessage());
        }

        return libro;
    }

    @Override
    public boolean existeLaCuenta(int id_cuenta) {
        
        String sql = "{call existeCuenta(?)}";
        
       try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)){
            stmt.setInt(1, id_cuenta);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
       }
       catch(Exception e){
           System.err.println("Error para obtener si la cuenta existe en la tabla Operaciones. " + e.getMessage());
       }
       return false;
    }
    
}
