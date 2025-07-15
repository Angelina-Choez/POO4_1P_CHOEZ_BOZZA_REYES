package com.proyecto;
/**
 * Clase abstracta que representa un usuario general del sistema.
 * Puede ser extendida por clases como Cliente o Repartidor.
 * Incluye información personal, credenciales y rol.
 *
 * Esta clase define el método abstracto {@code gestionarPedido}, que debe ser implementado por cada tipo de usuario según su comportamiento.
 *
 * @author Daniela Bozza
 */
public abstract class Usuario{
    protected String codigoUnico;
    protected String numCed;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasenia;
    protected String correo;
    protected Rol rol;
    
    /**
     * Constructor para inicializar los datos generales del usuario.
     *
     * @param codigoUnico   Código único del usuario.
     * @param numCed        Número de cédula.
     * @param nombres       Nombres del usuario.
     * @param apellidos     Apellidos del usuario.
     * @param usuario       Nombre de usuario para ingresar al sistema.
     * @param contrasenia   Contraseña del usuario.
     * @param correo        Correo electrónico.
     * @param rol           Rol que tiene en el sistema.
     */
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
    /**
     * Método abstracto que es implementado por las subclases para gestionar un pedido según su rol.
     */
    public abstract void gestionarPedido();

    /**
     * Representación textual del usuario, incluyendo su código, nombre completo y rol.
     *
     * @return cadena con información resumida del usuario.
     */
    @Override
    public String toString(){
        return "Código Único: "+codigoUnico+", Nombre: "+nombres+" "+apellidos+", Rol: "+rol;
    }
    // Getters y Setters

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
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
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