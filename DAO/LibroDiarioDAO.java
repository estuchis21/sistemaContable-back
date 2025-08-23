/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;       // Necesario para ResultSet
import java.sql.Timestamp;       // Para convertir a LocalDateTime
import sistemacontable.back.Interfaces.LibroDiarioI;
import sistemacontable.back.Models.Asientos;
import sistemacontable.back.Models.Operaciones;
import sistemacontable.back.ConnectionDB;


/**
 *
 * @author Esteban
 */
public class LibroDiarioDAO implements LibroDiarioI { 
    @Override
    public Asientos selectAsientoPorId(int id_asiento) {
        if(!existeAsiento(id_asiento)){
            System.err.println("No existe tal asiento");
            return null;  // corta la ejecución si no existe
        }

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
        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }
    
    
    @Override
    public boolean generarAsiento(Asientos asientos) {
        
        String sql = "{call sp_insertar_asiento(?)}";
        if(!existeAsiento(asientos.getId_asiento())){
            System.err.println("No existe tal asiento");
            return false; // no insertamos
        }
        
        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)){
            stmt.setString(1, asientos.getDescripcion());
            stmt.execute();
            return true;
        }
        catch(Exception e){
            System.err.println("Error" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean generarOperacionPorAsiento(Operaciones operaciones) {
        String sql = "{call insertarOpsEnAsientos(?)}";     
        
        if(!existeAsiento(operaciones.getId_asiento())){
            System.err.println("No existe tal asiento");
            return false; // no insertamos
        }
        
        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)){
            stmt.setInt(1, operaciones.getId_asiento());
            stmt.setInt(2, operaciones.getId_tipo_movimiento());
            stmt.setBigDecimal(3, operaciones.getMonto());
            stmt.execute();
            return true;
        }
        catch(Exception e){
            System.err.println("Error" + e.getMessage());
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

            return rs.next();  // true si hay fila, false si no
        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

}
