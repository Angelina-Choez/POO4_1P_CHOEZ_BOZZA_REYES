package com.proyecto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivos {
    public static List<String> leerArchivo(String nombreArchivo){
        List<String> lineas= new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), StandardCharsets.UTF_8))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo: " + e.getMessage());
    }
    return lineas;
    }

    public static void escribirArchivo(String nombreArchivo, String linea){
        try (BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo, true),StandardCharsets.UTF_8))){
            bw.write(linea);
            bw.newLine();
        } catch (IOException e){
            System.out.println("Error al escribir archivo: "+ e.getMessage());
        }
    }
}