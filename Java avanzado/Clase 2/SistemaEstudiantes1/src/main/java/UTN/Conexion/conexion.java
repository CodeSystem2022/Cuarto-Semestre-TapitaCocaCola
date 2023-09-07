package UTN.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConnection() {
        Connection conexion = null;
        // Variables para conectarnos a la base de datos
        var baseDatos = "estudiantes";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos; // Corrección de la URL
        var usuario = "root";
        var password = "Federico50";

        // Cargamos la clase del driver de MySQL en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Corrección en el nombre de la clase
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrió un error en la conexión: " + e.getMessage());
        } // Fin catch
        return conexion;
    } // Fin método getConnection
}
