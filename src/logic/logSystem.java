package logic;

import java.util.Scanner;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.util.Objects;



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
}
