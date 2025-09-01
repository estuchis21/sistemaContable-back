/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.back.Interfaces;

import sistemacontable.back.Models.Usuario;

/**
 *
 * @author Esteban
 */
public interface AuthI {
    public boolean registrar(Usuario users);
    public Usuario getUserById(int id_usuario);
    public Usuario login(String username, String contrasena);
}
