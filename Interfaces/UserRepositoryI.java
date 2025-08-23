/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.back.Interfaces;

import sistemacontable.back.Models.Usuario;

/**
 *
 * @author esteb
 */
public interface UserRepositoryI {
    public boolean insertUser(Usuario usuario);
    public Usuario getUserById(int id_usuario);
    public boolean verSiExiste(int dni, String email, String username);
}
