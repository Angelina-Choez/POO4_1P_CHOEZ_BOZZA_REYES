package com.proyecto;

import java.util.Scanner;

public class Repartidor extends Usuario{
    private String empresa;
    
    public Repartidor(String codigoUnico, String numCed, String nombres, String apellidos, String usuario, String contrasenia, String correo, Rol rol, String empresa) {
        super(codigoUnico, numCed, nombres, apellidos, usuario, contrasenia, correo, rol);
        this.empresa = empresa;
    }

    @Override
    public void gestionarPedido(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el código del pedido: ");
        String codigo= sc.nextLine();
        Pedido pedido= Sistema.buscarPedidoPorCodigo(codigo);

        if (pedido==null){
            System.out.println("El pedido no existe.");
        } else if (!pedido.getCodigoRepartidor().equals(this.codigoUnico)){
            System.out.println("Este peddo no está asignado a usted.");
        }

        System.out.println("Estado actual del pedido: "+pedido.getEstado());
        if (pedido.getEstado()==EstadoPedido.EN_PREPARACION){
            System.out.println("¿Desea cambiar el estado a EN_RUTA? (S/O)");
            String respuesta= sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")){
                pedido.setEstado(EstadoPedido.EN_RUTA);
                System.out.println("Estado cambiado a EN RUTA.");
                ManejoArchivos.escribirArchivo("pedidos.txt", pedido.toString());
            }
        } else if (pedido.getEstado()== EstadoPedido.EN_RUTA){
            System.out.println("¿Desea cambiar ele stado a ENTREGADO? (S/N)");
            String resp= sc.nextLine();
            if (resp.equalsIgnoreCase("S")){
                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("Estado cambiado a ENTREGADO.");
                ManejoArchivos.escribirArchivo("pedidos.txt", pedido.toString());
            }
        } else{
            System.out.println("El pedido ya está ENTREGADO.");
        }
    }

    @Override
    public String toString(){
        return super.toString()+ ", Empresa: "+empresa;
    }

    //Métodos Getters y Setters.
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}