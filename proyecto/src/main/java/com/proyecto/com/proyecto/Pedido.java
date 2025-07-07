package com.proyecto;
import java.time.LocalDate;

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
    private String idPago;

    //Constructor para inicializar los atributos.
    public Pedido(LocalDate fecha, String codigoProducto, int cantidad, double valorPagado, EstadoPedido estado, String codigoRepartidor, String codigoCliente, String idPago) {
        this.codigoPedido = generarCodigoPedido();
        this.fecha = fecha;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.estado = estado;
        this.codigoRepartidor = codigoRepartidor;
        this.codigoCliente = codigoCliente;
        this.idPago = idPago;    
    }

    //Método para generar un código de pedido único.
    private String generarCodigoPedido() {
        return "PED" + (++contadorPedidos);
    }

    //Método toString
    @Override
    public String toString(){
        String pago= "N/A";
        if(idPago!=null && !idPago.isEmpty()){
            pago = "ID de Pago: " + idPago;
        }
        return "Código de Pedido: "+codigoPedido+", Fecha: "+fecha +", Código de Producto: "+codigoProducto +", Cantidad: "+cantidad +", Valor Pagado: " + valorPagado +", Estado: "+estado+", Código de Repartidor: " + codigoRepartidor
            +", Código de Cliente: " + codigoCliente + ", " + pago;
    }

    //Métodos Getters y Setters.
    public String getCodigoPedido() {
        return codigoPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorPagado() {
        return valorPagado;
    }
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getCodigoRepartidor() {
        return codigoRepartidor;
    }
    public void setCodigoRepartidor(String codigoRepartidor){
        this.codigoRepartidor = codigoRepartidor;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getIdPago() {
        return idPago;
    }
    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }
} 