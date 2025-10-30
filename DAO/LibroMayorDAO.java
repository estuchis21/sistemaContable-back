package sistemacontable.back.DAO;

import sistemacontable.back.Models.LibroMayor;
import sistemacontable.back.ConnectionDB;
import sistemacontable.back.Interfaces.LibroMayorI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroMayorDAO implements LibroMayorI {

    @Override
    public List<LibroMayor> getLibroMayor(int idCuenta) {
        List<LibroMayor> libro = new ArrayList<>();
        String sql = "{call libroMayor(?)}"; // Stored Procedure que devuelve todos los movimientos de una cuenta

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCuenta);
            ResultSet rs = stmt.executeQuery();

            double saldoAcumulado = 0;

            while (rs.next()) {
                double debe = rs.getDouble("debe");
                double haber = rs.getDouble("haber");

                // Se calcula el movimiento y el saldo acumulado
                double movimiento = debe > 0 ? debe : -haber;
                saldoAcumulado += movimiento;

                // Determinar si el saldo es DEUDOR o ACREEDOR
                String tipoSaldoFinal = saldoAcumulado >= 0 ? "DEUDOR" : "ACREEDOR";

                LibroMayor lm = new LibroMayor(
                        rs.getInt("id_asiento"),
                        rs.getTimestamp("fecha_asiento") != null ? rs.getTimestamp("fecha_asiento").toLocalDateTime() : null,
                        rs.getString("descripcion"),
                        debe > 0 ? 1 : 2,   // 1=DEBE, 2=HABER
                        debe > 0 ? "DEBE" : "HABER",
                        movimiento,
                        saldoAcumulado,
                        tipoSaldoFinal
                );
                libro.add(lm);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el libro mayor: " + e.getMessage());
        }

        return libro;
    }

    @Override
    public boolean existeLaCuenta(int id_cuenta) {
        String sql = "{call existeCuenta(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id_cuenta);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error para obtener si la cuenta existe en Operaciones: " + e.getMessage());
        }
        return false;
    }
}
