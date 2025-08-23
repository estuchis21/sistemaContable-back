/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.back.Services;

import sistemacontable.back.Models.Cuentas;

/**
 *
 * @author Esteban
 */
public interface PlanDeCuentasServiceI {
    public boolean insertarCuenta(Cuentas cuentas);
    public Integer mostrarCuentaPorId(int id_cuenta);
}
