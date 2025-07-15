package com.proyecto;
import java.time.LocalDate;
/**
 * Representa a un cliente que extiende de la clase Usuario.
 * Contiene información adicional como celular y dirección.
 * El cliente puede generar pedidos y consultar su estado.
 * @author Paola Reyes
 */
public class Cliente extends Usuario{
    private String celular;
    private String direccion;
    /**
     * Constructor para crear un cliente con todos sus datos.
     *
     * @param codigoUnico  Código único del cliente
     * @param numCed       Número de cédula
     * @param nombres      Nombres del cliente
     * @param apellidos    Apellidos del cliente
     * @param usuario      Nombre de usuario
     * @param contrasenia  Contraseña del cliente
     * @param correo       Correo electrónico
     * @param rol          Rol asignado al cliente
     * @param celular      Número de celular
     * @param direccion    Dirección del cliente
     */

    public Cliente(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String celular, String direccion) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.celular = celular;
        this.direccion = direccion;
    }
        /**
     * Obtiene el número de celular del cliente.
     *
     * @return celular
     */
    public String getCelular() {
        return celular;
    }
        /**
     * Establece el número de celular del cliente.
     *
     * @param celular Número de celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
        /**
     * Obtiene la dirección del cliente.
     *
     * @return dirección
     */
    public String getDireccion() {
        return direccion;
    }
        /**
     * Establece la dirección del cliente.
     *
     * @param direccion Dirección del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Genera un nuevo pedido si el producto está disponible,
     * el pago ha sido verificado y hay un repartidor asignado.
     *
     * @param producto   Producto a pedir
     * @param cantidad   Cantidad deseada
     * @param pago       Método de pago
     * @param repartidor Repartidor asignado
     * @return Pedido generado o null si hay error
     */
    public Pedido generarPedido(Producto producto, int cantidad, Pago pago, Repartidor repartidor){
        if (producto==null || repartidor==null || pago==null || !producto.estaDisponible(cantidad) || !pago.isVerificado()){
            return null;
        }
        double total= producto.getPrecio()*cantidad;
        producto.reducirStock(cantidad);
        Pedido nuevoPedido= new Pedido(LocalDate.now(), producto.getCodigo(), cantidad, total, EstadoPedido.EN_PREPARACION, repartidor.getCodigoUnico(), this.getCodigoUnico(), pago);
        ManejoArchivos.escribirArchivo("pedidos.txt", nuevoPedido.toString());
        return nuevoPedido;
    }
    /**
     * Permite al cliente consultar el estado de su pedido.
     */
    @Override
    public void gestionarPedido(){
        ClienteServicio.consultarEstadoPedido(this);
    }
        /**
     * Devuelve una representación en texto del cliente.
     *
     * @return Información del cliente como cadena
     */

    @Override
    public String toString(){
        return super.toString() +", Celular: " + celular+", Direccioón"+direccion;
    }
}
