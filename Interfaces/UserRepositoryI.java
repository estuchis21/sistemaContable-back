/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemacontable.sistemaContable.back.Interfaces;

import sistemacontable.sistemaContable.back.Models.Usuario;

/**
 *
 * @author esteb
 */
public interface UserRepositoryI {
    public void insertUser(Usuario usuario);
    public Usuario getUserById(int id_usuario);
}
