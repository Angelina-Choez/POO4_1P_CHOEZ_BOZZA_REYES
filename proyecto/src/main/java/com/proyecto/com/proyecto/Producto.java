package com.proyecto;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private Categoria categoria;

        /**
     * Constructor para crear un producto con todos sus datos.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio unitario del producto.
     * @param stock Cantidad disponible en inventario.
     * @param categoria Categoría a la que pertenece el producto.
     */
    public Producto(String codigo, String nombre,double precio, int stock, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria= categoria;
    }

    //Métodos de la clase.
    public boolean estaDisponible(int cantidad){
        return cantidad>0 && cantidad<=stock;
    }

    public void reducirStock(int cantidad){
        if(estaDisponible(cantidad)){
            this.stock-=cantidad;
        }
    }

    @Override
    public String toString(){
        return String.format("%s - %s - $%.2f - Stock: %d", codigo, nombre, precio, stock);
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

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}