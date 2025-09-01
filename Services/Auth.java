package sistemacontable.back.Services;

import sistemacontable.back.DAO.UserDAO;
import sistemacontable.back.Interfaces.AuthI;
import sistemacontable.back.Models.Usuario;

public class Auth implements AuthI {
    private final UserDAO userDAO = new UserDAO();

    @Override
    public boolean registrar(Usuario usuario) {
        return userDAO.insertUser(usuario);
    }

    @Override
    public Usuario login(String username, String contrasena) {
        return userDAO.login(username, contrasena);
    }

    @Override
    public Usuario getUserById(int id_usuario) {
        return userDAO.getUserById(id_usuario);
    }
}
