

package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {   
    
    /* Datos de SQL Conexion */
        
        private static String conectionIp = "jdbc:mysql://localhost:3306/bicicletas";
        private static String userSQL = "root";
        private static String passwordSQL = "$cyKnaf9";
    
    public static boolean dataBaseTestConection (){
        boolean connection = false;
        
        
        
        
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);) {
            
            System.out.println("Database Connected ✔");
            connection = true;
       
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
            + "\nSLQState: " + e.getSQLState()
            + "\nMensaje: " + e.getMessage());
        }
        
        return connection;
    }

    public static void insertNewUser (String username, String password, String payMethod){
        String sentencia = "INSERT INTO bicicletas.usuario (UsNombre, UsContraseña, UsPago, UsFechaCuenta) " +
                "VALUES ('"+username+"','"+password+"','"+payMethod+"',now());";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ps.executeUpdate(sentencia);

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());

        }
    }

    public static boolean loginUser(String username, String password){
        boolean loginSuccescfully = false;
        String sentencia = "select UsId FROM usuario where UsNombre = '"+username+"' and UsContraseña ='"+password+"';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            while(resultado.next()){
                if (resultado.getInt(1)>0){
                    loginSuccescfully = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }
        return  loginSuccescfully;
    }
    
    public static boolean loginAdmin(String username, String password){
        boolean loginSuccescfully = false;
        String sentencia = "select AdId FROM administrador where AdNombre = '"+username+"' and AdContraseña ='"+password+"';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            while(resultado.next()){
                if (resultado.getInt(1)>0){
                    loginSuccescfully = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }
        return  loginSuccescfully;
    }
}
