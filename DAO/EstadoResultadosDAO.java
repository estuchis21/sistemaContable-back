package sistemacontable.back.DAO;

import sistemacontable.back.ConnectionDB;
import sistemacontable.back.Models.EstadoResultadosRubro;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstadoResultadosDAO {

    public List<EstadoResultadosRubro> getEstadoResultados(LocalDate fechaCierre) {
        List<EstadoResultadosRubro> lista = new ArrayList<>();
        String sql = "{call sp_estado_resultados_rubros(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setDate(1, Date.valueOf(fechaCierre));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstadoResultadosRubro rubro = new EstadoResultadosRubro();
                rubro.setRubro(rs.getString("Rubro"));
                rubro.setTotalIngresos(rs.getBigDecimal("Total_Ingresos"));
                rubro.setTotalGastos(rs.getBigDecimal("Total_Gastos"));
                rubro.setResultadoRubro(rs.getBigDecimal("Resultado_Rubro"));
                lista.add(rubro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
