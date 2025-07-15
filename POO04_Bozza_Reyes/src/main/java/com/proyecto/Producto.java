package com.proyecto;
/**
 * Representa un producto disponible para la venta.
 * Contiene información como código, nombre, precio, stock y categoría.
 * Permite verificar disponibilidad y reducir stock tras una venta.
 *
 * @author Choez Angelina
 */
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
    /**
     * Verifica si hay suficiente stock para una cantidad solicitada.
     *
     * @param cantidad Cantidad que se desea verificar.
     * @return true si la cantidad está disponible; false en caso contrario.
     */
    public boolean estaDisponible(int cantidad){
        return cantidad>0 && cantidad<=stock;
    }
    
    /**
     * Reduce el stock disponible según la cantidad especificada,
     * solo si la cantidad está disponible.
     *
     * @param cantidad Cantidad a descontar del stock.
     */

    public void reducirStock(int cantidad){
        if(estaDisponible(cantidad)){
            this.stock-=cantidad;
        }
    }
    /**
     * Representación en texto del producto con código, nombre, precio y stock.
     *
     * @return Cadena con la información del producto.
     */
    @Override
    public String toString(){
        return String.format("%s - %s - $%.2f - Stock: %d", codigo, nombre, precio, stock);
    }

    /**
     * Obtiene el código único del producto.
     *
     * @return código del producto.
     */

    public String getCodigo() {
        return codigo;
    }
    /**
     * Establece el código único del producto.
     *
     * @param codigo nuevo código.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto.
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del producto.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el precio unitario del producto.
     *
     * @return precio del producto.
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Establece el precio unitario del producto.
     *
     * @param precio nuevo precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Obtiene la cantidad disponible en stock.
     *
     * @return cantidad en stock.
     */

    public int getStock() {
        return stock;
    }
    /**
     * Establece la cantidad disponible en stock.
     *
     * @param stock nueva cantidad.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Obtiene la categoría del producto.
     *
     * @return categoría del producto.
     */
    public Categoria getCategoria() {
        return categoria;
    }
    /**
     * Establece la categoría del producto.
     *
     * @param categoria nueva categoría.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}