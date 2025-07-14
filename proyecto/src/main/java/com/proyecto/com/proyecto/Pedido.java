package com.proyecto;
import java.time.LocalDate;
/**
 * Representa un pedido realizado por un cliente.
 * Contiene información sobre el código único, fecha, producto, cantidad,
 * valor pagado, estado del pedido, códigos de repartidor y cliente, y el pago asociado.
 *
 * El código del pedido se genera automáticamente incrementando un contador.
 *
 * @author Paola Reyes
 */
public class Pedido {
    private static int contadorPedidos = 1000;
    
    private String codigoPedido;
    private LocalDate fecha;
    private String codigoProducto;
    private int cantidad;
    private double valorPagado;
    private EstadoPedido estado;
    private String codigoRepartidor;
    private String codigoCliente;
    private Pago pago;
    
    /**
     * Constructor principal que crea un pedido con todos sus datos.
     * El código de pedido se genera automáticamente.
     *
     * @param codigoPedido    Código base (se ignora, el código se genera automáticamente)
     * @param fecha           Fecha del pedido
     * @param codigoProducto  Código del producto solicitado
     * @param cantidad        Cantidad de productos pedidos
     * @param valorPagado     Valor total pagado
     * @param estado          Estado actual del pedido
     * @param codigoRepartidor Código del repartidor asignado
     * @param codigoCliente   Código del cliente que hizo el pedido
     * @param pago            Información del pago asociado al pedido
     */

    public Pedido(String codigoPedido, LocalDate fecha, String codigoProducto, int cantidad, double valorPagado, EstadoPedido estado, String codigoRepartidor, String codigoCliente, Pago pago) {
        this.codigoPedido = generarCodigoPedido();
        this.fecha = fecha;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.estado = estado;
        this.codigoRepartidor = codigoRepartidor;
        this.codigoCliente = codigoCliente;
        this.pago = pago;
    }
    /**
     * Constructor simplificado que genera el código del pedido automáticamente.
     *
     * @param fecha           Fecha del pedido
     * @param codigoProducto  Código del producto solicitado
     * @param cantidad        Cantidad de productos pedidos
     * @param valorPagado     Valor total pagado
     * @param estado          Estado actual del pedido
     * @param codigoRepartidor Código del repartidor asignado
     * @param codigoCliente   Código del cliente que hizo el pedido
     * @param pago            Información del pago asociado al pedido
     */
    public Pedido(LocalDate fecha, String codigoProducto, int cantidad,double valorPagado, EstadoPedido estado, String codigoRepartidor,String codigoCliente, Pago pago) {
        this("PED" , fecha, codigoProducto, cantidad,valorPagado, estado, codigoRepartidor, codigoCliente, pago);
    }
    /**
     * Genera un código único para el pedido, incrementando un contador.
     *
     * @return Código de pedido generado
     */
    private String generarCodigoPedido() {
        return "PED" + (++contadorPedidos);
    }
    
    /**
     * Devuelve una representación en texto del pedido.
     *
     * @return Cadena con detalles del pedido
     */
    @Override
    public String toString(){
        return "Código de Pedido: "+codigoPedido+", Fecha: "+fecha +", Código de Producto: "+codigoProducto +", Cantidad: "+cantidad +", Valor Pagado: " + valorPagado +", Estado: "+estado+", Código de Repartidor: " + codigoRepartidor
            +", Código de Cliente: " + codigoCliente + ", Pago" + pago.getFormaPago();
    }
    /**
     * Devuelve una cadena con formato para guardar el pedido en archivo,
     * separando los campos con punto y coma.
     *
     * @return Cadena para archivo con los datos del pedido
     */
    public String toArchivo() {
        return codigoPedido + ";" + fecha + ";" + codigoProducto + ";" + cantidad + ";" + valorPagado + ";" + estado + ";" + codigoRepartidor + ";" + codigoCliente + ";" + pago.getFormaPago() + ";" + pago.getReferencia() + ";" + pago.getMonto();
    }
    /**
     * Obtiene el código único del pedido.
     *
     * @return código del pedido
     */
    public String getCodigoPedido() {
        return codigoPedido;
    }
    /**
     * Obtiene la fecha del pedido.
     *
     * @return fecha del pedido
     */
    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha del pedido.
     *
     * @param fecha nueva fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene el código del producto pedido.
     *
     * @return código de producto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }
    /**
     * Establece el código del producto.
     *
     * @param codigoProducto nuevo código de producto
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    /**
     * Obtiene la cantidad pedida.
     *
     * @return cantidad de productos
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Establece la cantidad pedida.
     *
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el valor total pagado por el pedido.
     *
     * @return valor pagado
     */
    public double getValorPagado() {
        return valorPagado;
    }
    /**
     * Establece el valor pagado.
     *
     * @param valorPagado nuevo valor pagado
     */
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }
    /**
     * Obtiene el estado actual del pedido.
     *
     * @return estado del pedido
     */
    public EstadoPedido getEstado() {
        return estado;
    }
    /**
     * Establece el estado del pedido.
     *
     * @param estado nuevo estado
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    /**
     * Obtiene el código del repartidor asignado.
     *
     * @return código del repartidor
     */
    public String getCodigoRepartidor() {
        return codigoRepartidor;
    }
    
    /**
     * Establece el código del repartidor asignado.
     *
     * @param codigoRepartidor nuevo código de repartidor
     */
    public void setCodigoRepartidor(String codigoRepartidor){
        this.codigoRepartidor = codigoRepartidor;
    }
    /**
     * Obtiene el código del cliente que hizo el pedido.
     *
     * @return código del cliente
     */

    public String getCodigoCliente() {
        return codigoCliente;
    }
    /**
     * Establece el código del cliente.
     *
     * @param codigoCliente nuevo código de cliente
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}