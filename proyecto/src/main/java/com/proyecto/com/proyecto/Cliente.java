package com.proyecto;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class Cliente extends Usuario{
    private String celular;
    private String direccion;

    public Cliente(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String celular, String direccion) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.celular = celular;
        this.direccion = direccion;
    }

    //Métodos Getters y Setters 
    public String getCelular() { 
        return celular; 
    }
    public void setCelular(String celular) { 
        this.celular = celular; 
    }

    public String getDireccion() { 
        return direccion; 
    }
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }

    public Pedido comprarProducto(List<Producto> productos, List<Repartidor> repartidores){
       System.out.println("--------------OPCIÓN DE COMPRA--------------");
       System.out.println("Categorías disponibles: ");
       for (Producto producto: productos){
        System.out.println("- "+producto.getCategoria());
       } 
    }

    Scanner sc= new Scanner(System.in);
    System.out.println("Ingrese la categoría del producto que desea comprar: ");
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
