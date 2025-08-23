/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.DAO;

import sistemacontable.back.Interfaces.PlanDeCuentasI;
import sistemacontable.back.Models.Cuentas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemacontable.back.ConnectionDB;

/**
 *
 * @author esteb
 */
public class CuentasDAO implements PlanDeCuentasI {

    @Override
    public void insertCuenta(Cuentas cuenta) {
       // Llamamos al procedimiento almacenado "insertarUsuario"
        String sql = "{call insertarCuenta(?, ?, ?, ?)}"; // Procedimiento almacenado

        try (Connection conn = ConnectionDB.getConnection();  // Usamos la conexión de la clase ConexionDB
             CallableStatement stmt = conn.prepareCall(sql)) {

            // Asignamos los parámetros del usuario al procedimiento almacenado
            stmt.setString(1, cuenta.getCodigo());
            stmt.setString(2, cuenta.getNombre());
            stmt.setInt(3, cuenta.getId_Tipo_saldo());
            stmt.setFloat(4, cuenta.getSaldo());

            // Ejecutamos el procedimiento almacenado
            stmt.execute();
            System.out.println("Usuario insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar Cuenta: " + e.getMessage());
        }
    }

    @Override
    public void mostrarCuentaPorId(long id_cuenta) {
        String sql = "{call MostrarCuentaPorNombre(?)}";
        Cuentas cuenta = null;
        
        try (Connection conn = ConnectionDB.getConnection();
        CallableStatement stmt = conn.prepareCall(sql)){
            
            stmt.setLong(1, id_cuenta);
            try(var rs = stmt.executeQuery()){
                if(rs.next()){
                    cuenta = new Cuentas();
                    cuenta.setCodigo(rs.getString("codigo"));
                    cuenta.setNombre(rs.getString("nombre"));
                    cuenta.setIdTipo_saldo(rs.getInt("id_tipo_saldo"));
                    cuenta.setSaldo(rs.getLong("saldo"));
                   
                }
                System.out.println(id_cuenta);
       
            
        } catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
