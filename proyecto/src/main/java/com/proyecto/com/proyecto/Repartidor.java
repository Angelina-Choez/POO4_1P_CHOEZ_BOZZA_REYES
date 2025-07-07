package com.proyecto;

public class Repartidor extends Usuario{
    private String telefono;

    public Repartidor(String nombres, String apellidos, String telefono){
        super(nombres, apellidos);
        this.telefono= telefono;
    }
    
    public Repartidor(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String telefono) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.telefono = telefono;
    }

    @Override
    public void gestionarPedido(){
        System.out.println("El repartidor " + this.getNombres() + " " + this.getApellidos() + " está gestionando el pedido.");
    }

    @Override
    public String toString(){
        return super.toString()+ ", Teléfono: "+telefono;
    }

    //Métodos Getters y Setters.
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
