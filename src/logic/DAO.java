

package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class DAO {   
    
    /* Datos de SQL Conexion */
        
        private static String conectionIp = "jdbc:mysql://localhost:3306/bicicletas";
        private static String userSQL = "root";
        private static String passwordSQL = "";
    
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
    
    public static String getAdminTipo(String username){
        String tipoAdmin = "No fuchusca";
        String sentencia = "select AdTipo from administrador where AdNombre = '"+username+"';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            while(resultado.next()){
                tipoAdmin = resultado.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }
        return tipoAdmin;
    }
    
    public static void insertRecambio(String nombre,String precio, String tipo){
        String query = "insert into recambios (ReNombre, RePrecio,ReTipo) values ('"+nombre+"','"+precio+"','"+tipo+"')";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
            logSystem.crearLog("adminINsertRecambio -s", "Error al insertar una tabla en recambio -s");
        }
    }

    
    public static String[][] modeloFactura(){
        
        int facturas = 0;
        
        String query = "select count(*) from factura;";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                facturas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[][] array = new String[facturas][6];
        
        String sentencia = "select FacId, FacImporte, FacCliente, FacEmpleado, FacNombreArticulo, FacTipo from factura";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Facturas "+ facturas);
            while(resultado.next()){
                array[i][0] = Integer.toString(resultado.getInt(1));
                array[i][1] = Integer.toString(resultado.getInt(2));
                array[i][2] = Integer.toString(resultado.getInt(3));
                array[i][3] = Integer.toString(resultado.getInt(4));
                array[i][4] = resultado.getString(5);
                array[i][5] = resultado.getString(6);
                
                for (int j = 0; j < array.length ; j++){
                    System.out.println(array[i][0]);
                    System.out.println(array[i][1]);
                    System.out.println(array[i][2]);
                    System.out.println(array[i][3]);
                    System.out.println(array[i][4]);
                }
               
                i++;
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
    
    public static int actualizarPrecios (String Nome){
        String query = "select RePrecio from recambios where ReNombre = '"+Nome+"';";
        int precio=0;
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet retorno=ps.executeQuery(query);
                while (retorno.next()){
                    precio=retorno.getInt(1);
                }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
            logSystem.crearLog("adminINsertRecambio -s", "Error al insertar una tabla en recambio -s");
        }
        return precio;
    }
    
    
    public static String[][] getUsuariosDatos(){
        
        int numUsuarios = 0;
        
        String query = "select count(*) from usuario;";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                numUsuarios = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[][] array = new String[numUsuarios][4];
        
        String sentencia = "select UsId, UsNombre, UsPago, UsFechaCuenta from usuario;";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Facturas "+ numUsuarios);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
            while(resultado.next()){
                array[i][0] = Integer.toString(resultado.getInt(1));
                array[i][1] = resultado.getString(2);
                array[i][2] = resultado.getString(3);
                array[i][3] = dateFormat.format(resultado.getDate(4));

                
                /*
                for (int j = 0; j < array.length ; j++){
                    System.out.println(array[i][0]);
                    System.out.println(array[i][1]);
                    System.out.println(array[i][2]);
                    System.out.println(array[i][3]);
                }
                */
               
                i++;
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
    public static void insertarFactura(int importe, int idCliente, int idEmpleado, String tipo){
        String query = "insert into factura (FacImporte, FacCliente, FacEmpleado, FacNombreArticulo, FacTipo) values ('"+importe+"','"+idCliente+"','"+idEmpleado+"','"+"Bicicleta personal"+"','"+tipo+"')";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
            logSystem.crearLog("adminINsertRecambio -s", "Error al insertar una tabla en recambio -s");
        }
    }
    
    public static int conseguirIdCliente(String nombreCliente, String constraseña){
        String query = "select UsId from usuario where UsNombre = '"+nombreCliente+"';";
        int id=0;
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet retorno=ps.executeQuery(query);
                while (retorno.next()){
                    id=retorno.getInt(1);
                }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
            logSystem.crearLog("adminINsertRecambio -s", "Error al insertar una tabla en recambio -s");
        }
        return id;
    }
    
    
    public static String[] piezasCuadro(){
        
        int piezas = 0;
        
        String query = "select count(*) from recambios where ReTipo = 'cuadro';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                piezas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[] array = new String[piezas];
        
        String sentencia = "select ReNombre from recambios where ReTipo = 'cuadro';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Piezas "+ piezas);
            while(resultado.next()){
                if (i <= piezas){
                    String pieza = resultado.getString(1);
                    array [i] = pieza;
                    i++; 
                }     
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
    public static String[] piezasRuedas(){
        
        int piezas = 0;
        
        String query = "select count(*) from recambios where ReTipo = 'ruedas';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                piezas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[] array = new String[piezas];
        
        String sentencia = "select ReNombre from recambios where ReTipo = 'ruedas';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Piezas "+ piezas);
            while(resultado.next()){
                if (i <= piezas){
                    String pieza = resultado.getString(1);
                    array [i] = pieza;
                    i++; 
                }     
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
    public static String[] piezasFrenos(){
        
        int piezas = 0;
        
        String query = "select count(*) from recambios where ReTipo = 'frenos';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                piezas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[] array = new String[piezas];
        
        String sentencia = "select ReNombre from recambios where ReTipo = 'frenos';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Piezas "+ piezas);
            while(resultado.next()){
                if (i <= piezas){
                    String pieza = resultado.getString(1);
                    array [i] = pieza;
                    i++; 
                }     
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
    public static String[] piezasShock(){
        
        int piezas = 0;
        
        String query = "select count(*) from recambios where ReTipo = 'shock';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                piezas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[] array = new String[piezas];
        
        String sentencia = "select ReNombre from recambios where ReTipo = 'shock';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Piezas "+ piezas);
            while(resultado.next()){
                if (i <= piezas){
                    String pieza = resultado.getString(1);
                    array [i] = pieza;
                    i++; 
                }     
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
     public static String[] piezasHorquilla(){
        
        int piezas = 0;
        
        String query = "select count(*) from recambios where ReTipo = 'horquilla';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                piezas = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[] array = new String[piezas];
        
        String sentencia = "select ReNombre from recambios where ReTipo = 'horquilla';";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Piezas "+ piezas);
            while(resultado.next()){
                if (i <= piezas){
                    String pieza = resultado.getString(1);
                    array [i] = pieza;
                    i++; 
                }     
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
    
     public static String[][] getAdmins(){
        
        int numAdmins = 0;
        
        String query = "select count(*) from administrador;";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery(query);
            while(resultado.next()){
                numAdmins = resultado.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
           
        }
        
        String[][] array = new String[numAdmins][3];
        
        String sentencia = "select AdId, AdNombre, AdTipo from administrador;";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
             PreparedStatement ps = conexion.prepareStatement(sentencia)
        ) {

            ResultSet resultado = ps.executeQuery(sentencia);
            
            int i = 0;
            System.out.println("Facturas "+ numAdmins);
            while(resultado.next()){
                array[i][0] = Integer.toString(resultado.getInt(1));
                array[i][1] = resultado.getString(2);
                array[i][2] = resultado.getString(3);
                

                
                /*
                for (int j = 0; j < array.length ; j++){
                    System.out.println(array[i][0]);
                    System.out.println(array[i][1]);
                    System.out.println(array[i][2]);
                    System.out.println(array[i][3]);
                }
                */
               
                i++;
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                + "\nSLQState: " + e.getSQLState()
                + "\nMensaje: " + e.getMessage());
        }

        return array;
    }
     
     public static void deleteAdmin(int Admin){
        String query = "delete from administrador where AdId = "+ Admin+";";
        try (Connection conexion = DriverManager.getConnection(
                conectionIp, userSQL, passwordSQL);
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
            logSystem.crearLog("adminINsertRecambio -s", "Error al insertar una tabla en recambio -s");
        }
    }
     
}
