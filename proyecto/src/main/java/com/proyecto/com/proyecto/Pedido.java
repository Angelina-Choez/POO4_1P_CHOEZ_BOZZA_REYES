package com.proyecto;
import java.util.Date;

public class Pedido {
    private static int contadorPedidos = 1000;

    private String codigoPedido;
    private Date fecha;
    private String codigoProducto;
    private int cantidad;
    private double valorPagado;
    private String estado;
    private String codigoRepartidor;

    public Pedido(Date fecha, String codigoProducto, int cantidad, double valorPagado, String estado, String codigoRepartidor) {
        this.codigoPedido = generarCodigoPedido();
        this.fecha = fecha;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.estado = estado;
        this.codigoRepartidor = codigoRepartidor;
    }

    private String generarCodigoPedido() {
        return "PED" + (++contadorPedidos);
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
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

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoRepartidor() {
        return codigoRepartidor;
    }
    public void setCodigoRepartidor(String codigoRepartidor){
        this.codigoRepartidor = codigoRepartidor;
    }
}
