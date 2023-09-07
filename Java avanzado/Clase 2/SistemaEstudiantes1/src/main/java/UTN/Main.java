package UTN;
import UTN.Conexion.conexion;

public class Main {
    public static void main(String[] args) {
        var connection = conexion.getConnection();
        if (connection != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Error al conectarse");
        }
    } // fin del método main
} // fin de la clase Main