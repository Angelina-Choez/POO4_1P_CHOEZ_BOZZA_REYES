package com.proyecto;
/**
 * Representa a un repartidor dentro del sistema.
 * Hereda de la clase Usuario e incluye información adicional como la empresa a la que pertenece.
 * El repartidor puede gestionar pedidos.
 *
 * @author Daniela Bozza
 */
public class Repartidor extends Usuario{
    private String empresa;
    /**
     * Constructor para crear un repartidor con todos sus datos.
     *
     * @param codigoUnico  Código único del repartidor.
     * @param numCed       Número de cédula.
     * @param nombres      Nombres del repartidor.
     * @param apellidos    Apellidos del repartidor.
     * @param usuario      Nombre de usuario del sistema.
     * @param contrasenia  Contraseña de acceso.
     * @param correo       Correo electrónico.
     * @param rol          Rol del usuario (debe ser ROL_REPARTIDOR).
     * @param empresa      Empresa de reparto a la que pertenece.
     */

    public Repartidor(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String empresa) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.empresa = empresa;
    }
    /**
     * Método sobrescrito que muestra un mensaje indicando que el repartidor está gestionando el pedido.
     */
    @Override
    public void gestionarPedido(){
        System.out.println("El repartidor " + this.getNombres() + " " + this.getApellidos() + " está gestionando el pedido.");
    }
    /**
     * Devuelve una representación en texto del repartidor incluyendo su empresa.
     *
     * @return Información del repartidor en forma de texto.
     */
    @Override
    public String toString(){
        return super.toString()+ ", Empresa: "+ empresa;
    }
    /**
     * Obtiene el nombre de la empresa del repartidor.
     *
     * @return nombre de la empresa.
     */
    public String getEmpresa() {
        return empresa;
    }
    /**
     * Establece el nombre de la empresa del repartidor.
     *
     * @param empresa nombre de la empresa.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}