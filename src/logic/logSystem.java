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
    
    public static void clearLog(){
        File directory = new File("src\\logs");
 
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
    
    public static void jsonPrueba() throws FileNotFoundException, IOException, ParseException{
        // creating JSONObject
        JSONObject jo = new JSONObject();
          
        // putting data to JSONObject
        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 25);
          
        // for address data, first create LinkedHashMap
        Map m = new LinkedHashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);
          
        // putting address to JSONObject
        jo.put("address", m);
          
        // for phone numbers, first create JSONArray 
        JSONArray ja = new JSONArray();
          
        m = new LinkedHashMap(2);
        m.put("type", "home");
        m.put("number", "212 555-1234");
          
        // adding map to list
        ja.add(m);
          
        m = new LinkedHashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");
          
        // adding map to list
        ja.add(m);
          
        // putting phoneNumbers to JSONObject
        jo.put("phoneNumbers", ja);
          
        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("src/logs/JSONExample.json");
        pw.write(jo.toJSONString());
          
        pw.flush();
        pw.close();
        jsonLecturaPrueba();
    }
    
    public static String[] jsonLecturaPrueba() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        
        String arrayDatos[] = new String [3];
        
        JSONArray a = (JSONArray) parser.parse(new FileReader("src/logic/config.json"));
        for (Object o : a)
        {
          JSONObject object = (JSONObject) o;

          String jdbc = (String) object.get("jdbc");
          arrayDatos[0] = jdbc;

          String user = (String) object.get("user");
          arrayDatos[1] = user;


          String passwd = (String) object.get("password");
          arrayDatos[2] = passwd;
        }
        
        return arrayDatos;
    }  
   
}
