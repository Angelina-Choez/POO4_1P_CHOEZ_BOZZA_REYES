package com.proyecto;

enum Rol{
    Cliente, Conductor
}
public class Usuario{
    protected String codigoUnico;
    protected String numCed;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    protected Rol rol;
    
    // Constructor por defecto
    public Usuario(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contraseña, String correo, Rol rol) {
        this.codigoUnico = codigoUnico;
        this.numCed = numCed;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
    }

    //Métodos
    public void gestionarPedido(){

    }
    public void consultarPedido(){

    }

    //Getters y Setters
    public String getCodigoUnico() {
        return codigoUnico;
    }   
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    public String getNumCed() {
        return numCed;
    }
    public void setNumCed(String numCed) {
        this.numCed = numCed;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
 }