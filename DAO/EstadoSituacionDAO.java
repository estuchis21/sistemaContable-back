package sistemacontable.back.DAO;

import sistemacontable.back.ConnectionDB;
import sistemacontable.back.Models.EstadoSituacionRubro;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstadoSituacionDAO {

    public List<EstadoSituacionRubro> getEstadoSituacion(LocalDate fechaCierre) {
        List<EstadoSituacionRubro> lista = new ArrayList<>();
        String sql = "{call sp_estado_situacion_patrimonial_rubros(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setDate(1, Date.valueOf(fechaCierre));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstadoSituacionRubro rubro = new EstadoSituacionRubro();
                rubro.setRubro(rs.getString("Rubro"));
                rubro.setTotalActivos(rs.getBigDecimal("Total_Activos"));
                rubro.setTotalPasivos(rs.getBigDecimal("Total_Pasivos"));
                rubro.setTotalPatrimonio(rs.getBigDecimal("Total_Patrimonio"));
                lista.add(rubro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
