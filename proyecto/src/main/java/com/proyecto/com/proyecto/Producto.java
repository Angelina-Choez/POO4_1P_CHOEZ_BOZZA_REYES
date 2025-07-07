package com.proyecto;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    //Métodos
    public void reducirStock(int cantidad){
        if (this.stock>=cantidad){
            this.stock-= cantidad;
        }else{
            System.out.println("No hay suficiente stock.");
        }
    }
    
    public boolean estaDisponible(int cantidad){
        return this.stock >= cantidad;
    }

    @Override
    public String toString(){
        return "Categoría: "+categoria+", Código: "+codigo+", Nombre: "+nombre+", Precio: $"+precio;
    }
    
    //Métodos Getters y Setters.
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

