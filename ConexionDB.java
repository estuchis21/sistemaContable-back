package sistemacontable.sistemaContable.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistemacontable"; // Cambia tu URL si es necesario
    private static final String USER = "root"; // Usuario de la base de datos
    private static final String PASSWORD = ""; // Contraseña del usuario

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Registrar el driver MySQL (JDBC 4.0 lo hace automáticamente, pero para estar seguros)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}


