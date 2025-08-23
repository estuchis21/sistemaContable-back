/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.back.Interfaces;

import sistemacontable.back.Models.Asientos;
import sistemacontable.back.Models.Operaciones;

/**
 *
 * @author Esteban
 */
public interface LibroDiarioI {
    public Asientos selectAsientoPorId(int id_asiento);
    public boolean existeAsiento(int id_cuenta);
    public boolean generarAsiento(Asientos asientos);
    public boolean generarOperacionPorAsiento(Operaciones operaciones);
}
