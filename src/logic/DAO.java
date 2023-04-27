

package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {
    public static void dataBaseTestConection (){
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.21:3306/bicicletas", "usuario1", "usuario1");) {
            
            System.out.println("Database Connected ✔");
       
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
            + "\nSLQState: " + e.getSQLState()
            + "\nMensaje: " + e.getMessage());
        }
    }
}
