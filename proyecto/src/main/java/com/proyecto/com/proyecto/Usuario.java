package com.proyecto;

public abstract class Usuario{
    protected String codigoUnico;
    protected String numCed;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasenia;
    protected String correo;
    protected Rol rol;
    
    // Constructor para inicializar los atributos.
    public Usuario(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol) {
        this.codigoUnico = codigoUnico;
        this.numCed = numCed;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.rol = rol;
    }

    //Métodos de la clase.
    public abstract void gestionarPedido();

     @Override
     public String toString(){
        return "Código Único: "+codigoUnico+", Nombre: "+nombres+" "+apellidos+", Rol: "+rol;
     }

    //Métodos Getters y Setters.
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
        return contrasenia;
    }
    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
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