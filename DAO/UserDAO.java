package sistemacontable.sistemaContable.back.DAO;

import sistemacontable.sistemaContable.back.Interfaces.UserRepositoryI;
import sistemacontable.sistemaContable.back.Models.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO implements UserRepositoryI {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=sistemaContable";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void insertUser(Usuario usuario) {
        String sql = "{call insertarUsuario(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, usuario.getDni());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getMail());
            stmt.setString(5, usuario.getUsername());
            stmt.setString(6, usuario.getContrasena());
            stmt.setInt(7, usuario.getIdRol());

            stmt.execute();
            System.out.println("Usuario insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        }
    }

@Override
public Usuario getUserById(int id_usuario) {
    String sql = "{call selectUsuarioById(?)}"; // Procedimiento almacenado
    Usuario usuario = null; // No lo creamos aquí, solo lo recuperamos de la base de datos

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         CallableStatement stmt = conn.prepareCall(sql)) {

        // Establecemos el parámetro id_usuario en el procedimiento almacenado
        stmt.setInt(1, id_usuario);

        // Ejecutamos la consulta
        try (var rs = stmt.executeQuery()) {
            if (rs.next()) { // Si el usuario se encuentra
                usuario = new Usuario(); // Aquí solo asignamos los valores, no creamos el objeto

                // Asignamos los valores recuperados desde la base de datos
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

    return usuario; // Devolvemos el objeto Usuario con los datos encontrados, o null si no se encontró
}
}
