/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Interfaces;

import java.util.List; // ✅ Corregido
import sistemacontable.back.Models.LibroMayor;

public interface LibroMayorI {
    public List<LibroMayor> getLibroMayor(int idCuenta);
    public boolean existeLaCuenta(int id_cuenta);
}


