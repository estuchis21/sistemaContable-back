package sistemacontable.back.DAO;
import sistemacontable.back.ConnectionDB;  // Importar ConexionDB

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import sistemacontable.back.Interfaces.UserRepositoryI;
import sistemacontable.back.Models.Usuario;
import java.sql.ResultSet;


public class UserDAO implements UserRepositoryI {

    @Override
    public boolean insertUser(Usuario usuario) {
        String sql = "{call insertarUsuario(?, ?, ?, ?, ?, ?, ?)}";

        if (verSiExiste(usuario.getDni(), usuario.getMail(), usuario.getUsername())) {
            System.err.println("No se puede crear tal usuario porque ya existe");
            return false;
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            // Asignamos parámetros en el orden correcto
            stmt.setInt(1, usuario.getIdRol());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getMail());
            stmt.setString(5, usuario.getUsername());
            stmt.setString(6, usuario.getContrasena());
            stmt.setInt(7, usuario.getDni());

            stmt.execute();
            System.out.println("Usuario insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }


    @Override
    public Usuario getUserById(int id_usuario) {
        String sql = "{call selectUsuarioById(?)}"; // Procedimiento almacenado para obtener un usuario
        Usuario usuario = null;

        try (Connection conn = ConnectionDB.getConnection();  // Usamos la conexión de la clase ConexionDB
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id_usuario);

            // Ejecutamos la consulta
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setDni(rs.getInt("DNI"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setMail(rs.getString("mail"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setIdRol(rs.getInt("id_rol"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
        }

        return usuario;
    }

    @Override
    public boolean verSiExiste(int dni, String email, String username) {
        if (dni <= 0 || email == null || email.isEmpty() || username == null || username.isEmpty()) {
            System.err.println("Faltan datos importantes");
            return false; // o lanzar excepción
        }

        String sql = "{call EXISTENTE (?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            // Seteamos los parámetros
            stmt.setInt(1, dni);
            stmt.setString(2, email);
            stmt.setString(3, username);

            // Ejecutamos y asignamos a ResultSet
            try (ResultSet rs = stmt.executeQuery()) {
                // Si devuelve al menos un registro, existe
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}