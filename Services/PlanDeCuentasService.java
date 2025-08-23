/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Services;

import sistemacontable.back.Interfaces.PlanDeCuentasServiceI;
import sistemacontable.back.DAO.CuentasDAO;
import sistemacontable.back.Models.Cuentas;

/**
 *
 * @author Esteban
 */
public class PlanDeCuentasService implements PlanDeCuentasServiceI {

    CuentasDAO cuentasDAO = new CuentasDAO();
    
    @Override
    public boolean insertarCuenta(Cuentas cuentas) {
        try{
            cuentasDAO.insertCuenta(cuentas);
            return true;
        }
        catch(Exception e){
            System.err.println("Error. " + e.getMessage());
        }
        return false;
    }

    @Override
    public Integer mostrarCuentaPorId(int id_cuenta) {
        
        try{
            cuentasDAO.mostrarCuentaPorId(id_cuenta);
        }
        catch(Exception e){
            System.err.println("Error. " + e.getMessage());
        }
        return null;
    }
    
}
