package com.proyecto;
import java.time.LocalDate;

public class Cliente extends Usuario{
    private String celular;
    private String direccion;

    public Cliente(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String celular, String direccion) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.celular = celular;
        this.direccion = direccion;
    }
        
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
    public Pedido generarPedido(Producto producto, int cantidad, Pago pago, Repartidor repartidor){
        if (producto==null || repartidor==null || pago==null){
            return null;
        }
        if (!producto.estaDisponible(cantidad)){
            return null;
        }
        if(!pago.isVerificado()){
            return null;
        }
        double total= producto.getPrecio()*cantidad;
        producto.reducirStock(cantidad);
        return new Pedido(LocalDate.now(), producto.getCodigo(), cantidad, total, EstadoPedido.EN_PREPARACION, repartidor.getCodigoUnico(), this.getCodigoUnico(), pago);
    }
    @Override
    public void gestionarPedido(){
        ClienteServicio.consultarEstadoPedido(this);
    }
    @Override
    public String toString(){
        return super.toString() +", Celular: " + celular+", Direccioón"+direccion;
    }
}
