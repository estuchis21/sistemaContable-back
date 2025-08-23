package sistemacontable.back.DAO;
import sistemacontable.sistemaContable.back.ConexionDB; // Importar ConexionDB

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import sistemacontable.back.Interfaces.UserRepositoryI;
import sistemacontable.back.Models.Usuario;

public class UserDAO implements UserRepositoryI {

    @Override
    public void insertUser(Usuario usuario) {
        // Llamamos al procedimiento almacenado "insertarUsuario"
        String sql = "{call insertarUsuario(?, ?, ?, ?, ?, ?, ?)}"; // Procedimiento almacenado

        try (Connection conn = ConexionDB.getConnection();  // Usamos la conexión de la clase ConexionDB
             CallableStatement stmt = conn.prepareCall(sql)) {

           //  Asignamos los parámetros del usuario al procedimiento almacenado
            stmt.setInt(1, usuario.getDni());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getMail());
            stmt.setString(5, usuario.getUsername());
            stmt.setString(6, usuario.getContrasena());
            stmt.setInt(7, usuario.getIdRol());

           //  Ejecutamos el procedimiento almacenado
            stmt.execute();
            System.out.println("Usuario insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario getUserById(int id_usuario) {
        String sql = "{call selectUsuarioById(?)}"; // Procedimiento almacenado para obtener un usuario
        Usuario usuario = null;

        try (Connection conn = ConexionDB.getConnection();  // Usamos la conexión de la clase ConexionDB
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
}