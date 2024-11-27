package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion {
    
    static String url = "jdbc:mysql://javaproyecto.c4twvuokhnt7.us-east-1.rds.amazonaws.com:3306/PROYECTO_JAVA";
    static String user = "admin";
    static String pass = "javaproyecto1";
    
    // Método para establecer la conexión a la base de datos
    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
    
    // Método para ejecutar la consulta y mostrar los resultados
    public static void ejecutarConsulta(Connection con, String query) {
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Crear un Statement para ejecutar la consulta
            stmt = con.createStatement();
            
            // Ejecutar la consulta
            rs = stmt.executeQuery(query);
            
            // Imprimir los resultados de la consulta
            System.out.println("Resultados de la consulta: ");
            
            // Iterar sobre el ResultSet
            while (rs.next()) {
                String nombre = rs.getString("nombre");  // Obtener la columna 'nombre'
                String contrasena = rs.getString("contrasena");  // Obtener la columna 'contrasena'
                
                // Imprimir los resultados
                System.out.println("nombre: " + nombre + " contraseña: " + contrasena);
            }
            
        } catch (SQLException e) {
            // Manejar la excepción
            System.out.println("Error al ejecutar la consulta");
            e.printStackTrace();  // Imprimir detalles del error
        } finally {
            // Cerrar recursos, si no son nulos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Manejar errores al cerrar los recursos
            }
        }
    }
}
