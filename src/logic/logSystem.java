package logic;

import java.util.Scanner;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class logSystem {


    /**
     * Crea un log con la ayuda de un script de python.
    */


    public static void crearLog(String modulo, String errorTipo ){
        System.out.println("Crear log");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        try {
            
        // Crear el proceso que ejecuta el archivo Python
        Process p = Runtime.getRuntime().exec("python src\\logic\\logCreator.py Hora:"+dateFormat.format(date)+" -s Modulo:"+modulo+" Instruccion:"+errorTipo);
        
        // Obtener la salida del proceso
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        
        // Leer la salida del proceso
        String s;
        System.out.println("Salida del proceso:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        // Leer la salida de error del proceso
        System.out.println("Error del proceso:\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina los logs
     */
    
    public static void clearLog(){
        File directory = new File("src\\logs");
 
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
    
    /**
     * Lee las credenciales de la conexión a la base de datos, en el archivo config.json.
     */
    
    public static String[] jsonLecturaConnectionData() throws FileNotFoundException, IOException, ParseException {
        Object ob = new JSONParser().parse(new FileReader("src/logic/config.json"));
        JSONObject js = (JSONObject) ob;
        
        
        
        String arrayDatos[] = new String [3];
        
        arrayDatos [0] = (String) js.get("password");
        arrayDatos [1] = (String) js.get("user");
        arrayDatos [2] = (String) js.get("jdbc");
        
        return arrayDatos;
    }  
    
    /**
     * Escribe datos en config.json
     */
    
    public static void jsonEscrituraDatos(String jdbc, String user, String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jdbc", jdbc);
        jsonObject.put("user", user);
        jsonObject.put("password", password);
        
        try (FileWriter writer = new FileWriter("src/logic/config.json")) {
            writer.write(jsonObject.toJSONString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
   
}
