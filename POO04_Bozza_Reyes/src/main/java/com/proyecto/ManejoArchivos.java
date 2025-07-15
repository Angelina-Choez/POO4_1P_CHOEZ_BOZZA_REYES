package com.proyecto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase utilitaria para el manejo de archivos de texto.
 * Permite leer líneas desde un archivo, escribir nuevas líneas
 * y sobrescribir completamente el contenido de un archivo.
 *
 * Las operaciones utilizan codificación UTF-8.
 *
 * @author Daniela Bozza
 * @author Paola Reyes
 *
 */

public class ManejoArchivos {
    /**
     * Lee todas las líneas de un archivo de texto.
     *
     * @param nombreArchivo Ruta del archivo a leer
     * @return Lista con las líneas del archivo. Si hay error, retorna lista vacía.
     */
    public static List<String> leerArchivo(String nombreArchivo){
        
        List<String> lineas= new ArrayList<>();
        System.out.println("Leyendo: " + nombreArchivo);
    try (InputStream is = ManejoArchivos.class.getClassLoader().getResourceAsStream(nombreArchivo);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
        String linea;
        
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo: " + e.getMessage());
    }
    return lineas;
    }
    
    /**
     * Escribe una línea en un archivo de texto.
     * Si el archivo ya existe, se añade la línea al final (modo append).
     *
     * @param nombreArchivo Ruta del archivo donde se va a escribir
     * @param linea         Contenido a escribir
     */
    public static void escribirArchivo(String nombreArchivo, String linea){
        try (BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo, true),StandardCharsets.UTF_8))){
            bw.write(linea);
            bw.newLine();
        } catch (IOException e){
            System.out.println("Error al escribir archivo: "+ e.getMessage());
        }
    }
    /**
     * Sobrescribe completamente un archivo con el contenido proporcionado.
     *
     * @param ruta      Ruta del archivo a sobrescribir
     * @param contenido Lista de líneas que reemplazarán el contenido anterior
     */
    public static void sobrescribirArchivo(String ruta, List<String> contenido) {
        try (PrintWriter pw = new PrintWriter(ruta)) {
            for (String linea : contenido) {
            pw.println(linea);
            }
            } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo: " + ruta);
        }
    }
}