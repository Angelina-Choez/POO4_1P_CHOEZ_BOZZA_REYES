package com.proyecto;

public class Repartidor extends Usuario{
    private String empresa;

    public Repartidor(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String empresa) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.empresa = empresa;
    }

    @Override
    public void gestionarPedido(){
        System.out.println("El repartidor " + this.getNombres() + " " + this.getApellidos() + " está gestionando el pedido.");
    }

    @Override
    public String toString(){
        return super.toString()+ ", Empresa: "+ empresa;
    }
    
    //Métodos Getters y Setters.

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}