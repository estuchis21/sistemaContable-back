/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Services;

import sistemacontable.back.DAO.UserDAO;
import sistemacontable.back.Interfaces.AuthI;
import sistemacontable.back.Models.Usuario;

/**
 *
 * @author Esteban
 */
public class Auth implements AuthI {
    UserDAO userDAO = new UserDAO();

    @Override
    public boolean registrar(Usuario users) {
        userDAO.insertUser(users);
        return false;
    }

    @Override
    public Usuario getUserById(int id_usuario) {
        userDAO.getUserById(id_usuario);
        return null;
    }
    
    
    
}
