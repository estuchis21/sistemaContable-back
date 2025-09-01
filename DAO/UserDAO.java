package sistemacontable.back.DAO;

import sistemacontable.back.ConnectionDB;
import sistemacontable.back.Interfaces.UserRepositoryI;
import sistemacontable.back.Models.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO implements UserRepositoryI {

    @Override
    public boolean insertUser(Usuario usuario) {
        // Procedimiento almacenado
        String sql = "{call dbo.InsertarUsuario(?, ?, ?, ?, ?, ?, ?)}";

        System.out.println("Insertando usuario:");
        System.out.println("idRol: " + usuario.getIdRol());
        System.out.println("Nombres: " + usuario.getNombres());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Mail: " + usuario.getMail());
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("DNI: " + usuario.getDni());

        // Validar si ya existe
        if (verSiExiste(usuario.getDni(), usuario.getMail(), usuario.getUsername())) {
            System.err.println("No se puede crear tal usuario porque ya existe");
            return false;
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            // Hashear la contraseña
            String hashedPassword = BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt());

            // IMPORTANTE: el orden debe coincidir con el SP
            stmt.setInt(1, usuario.getIdRol());        // @id_rol
            stmt.setString(2, usuario.getNombres());  // @nombres
            stmt.setString(3, usuario.getApellido()); // @apellido
            stmt.setString(4, usuario.getMail());     // @mail
            stmt.setString(5, usuario.getUsername()); // @username
            stmt.setString(6, hashedPassword);        // @clave_hash
            stmt.setInt(7, usuario.getDni());         // @DNI

            stmt.execute();
            System.out.println("Usuario insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            e.printStackTrace(); // Para detalles completos del error
            return false;
        }
    }
    
    @Override
    public boolean verSiExiste(int dni, String email, String username) {
        String sql = "{call EXISTENTE (?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, dni);
            stmt.setString(2, email);
            stmt.setString(3, username);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // devuelve true si hay registro
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM Usuarios WHERE username = ?";

        try (Connection conn = ConnectionDB.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("clave_hash");

                if (BCrypt.checkpw(password, hashedPassword)) {
                    System.out.println("Login exitoso");

                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setIdRol(rs.getInt("id_rol"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setMail(rs.getString("mail"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setDni(rs.getInt("DNI"));
                    return usuario;
                } else {
                    System.err.println("Contraseña incorrecta");
                }
            } else {
                System.err.println("Usuario no encontrado");
            }
        } catch (SQLException e) {
            System.err.println("Error en login: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Usuario getUserById(int id_usuario) {
        String sql = "{call selectUsuarioById(?)}";
        Usuario usuario = null;

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id_usuario);

            try (ResultSet rs = stmt.executeQuery()) {
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
