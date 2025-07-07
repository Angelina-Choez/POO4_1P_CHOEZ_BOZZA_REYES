package com.proyecto;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Producto> productos = new ArrayList<>();
    private static final List<Pedido> pedidos = new ArrayList<>(); 
    
    public static void agregarUsuario(Usuario usuario){
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        } else {
            System.out.println("El usuario ya existe o es nulo.");
        }
    }

    public static Usuario buscarUsuario(String codigoUnico){
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigoUnico().equals(codigoUnico)) {
                return usuario;
            }
        }
        return null; //Usuario no encontrado
    }

    public static void List<Repartidor> obtenerRepartidores(){
        List<Repartidor> repartidores = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Repartidor) {
                repartidores.add((Repartidor) usuario);
            }
        }
        return repartidores;
    }

    public static Producto buscarProductoPorCodigo(String codigo){
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null; //Producto no encontrado
    }

    public static void agregarProducto(Producto producto){
        if (producto !=null && buscarProductoPorCodigo(producto.getCodigo())==null){
            productos.add(producto);
        }else{
            System.out.println("El producto ya existe o es nulo.");
        }
    }

    public static void List<Producto> obtenerProductos(){
        return productos;
    }

    public static void agregarPedido(Pedido pedido){
        if (pedido!=null){
            pedidos.add(pedido);
        }else{
            System.out.println("El pedido es nulo.");
        }
    }

    public static Pedido buscarPedidoPorCodigo(String codigoPedido){
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoPedido().equalsIgnoreCase(codigoPedido)) {
                return pedido;
            }
        }
        return null; //Pedido no encontrado
    }

    public static List<Pedido> obtenerPedidosPorCliente(String codigoCliente) {
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoCliente().equals(codigoCliente)) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }

    public static List<Usuario> obtenerUsuarios(){
        return usuarios;
    }

    public static List<Pedido> obtenerPedidos(){
        return pedidos;
    }
}
