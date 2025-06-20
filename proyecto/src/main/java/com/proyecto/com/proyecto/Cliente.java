package com.proyecto;

public class Cliente extends Usuario{
    private String celular;
    private String direccion;

    public Cliente(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contraseña, String correo, Rol rol, String celular, String direccion) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contraseña, correo, rol);
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

}
