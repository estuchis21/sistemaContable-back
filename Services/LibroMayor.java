/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Services;

import java.util.List;
import sistemacontable.back.DAO.LibroMayorDAO;
import sistemacontable.back.Interfaces.LibroMayorI;

/**
 *
 * @author Esteban
 */
public class LibroMayor implements LibroMayorI {

    private final LibroMayorDAO libroMayorDAO = new LibroMayorDAO();

    @Override
    public List<sistemacontable.back.Models.LibroMayor> getLibroMayor(int idCuenta) {
        return libroMayorDAO.getLibroMayor(idCuenta);
    }

    @Override
    public boolean existeLaCuenta(int id_cuenta) {
        return libroMayorDAO.existeLaCuenta(id_cuenta);
    }


    
}
