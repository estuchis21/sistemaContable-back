/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.back.Interfaces;

import sistemacontable.back.Models.Cuentas;

/**
 *
 * @author esteb
 */
public interface PlanDeCuentasI {
    public void insertCuenta(Cuentas cuenta);
    public void mostrarCuentaPorId(long id_cuenta);
}
