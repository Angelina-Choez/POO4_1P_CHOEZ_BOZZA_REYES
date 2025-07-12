package com.proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Producto> productos = new ArrayList<>();
    private static final List<Pedido> pedidos = new ArrayList<>(); 
    
    public static void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public static void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
        ManejoArchivos.escribirArchivo("pedidos.txt", pedido.toString());
    }

    public static Pedido buscarPedidoPorCodigo(String codigo){
        for(Pedido p: pedidos){
            if (p.getCodigoPedido().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        return null;
    }

    public static List<Producto> obteneProductos(){
        return productos;
    }

    public static List<Repartidor> obtenerRepartidors(){
        List<Repartidor> lista= new ArrayList<>();
        for(Usuario u: usuarios){
            if (u instanceof Repartidor){
                lista.add((Repartidor)u);
            }
        }
        return lista;
    }

    public static List<Pedido> obtenerPedidosPorCliente(String codigoCliente){
        List<Pedido> lista= new ArrayList<>();
        for (Pedido p: pedidos){
            if (p.getCodigoCliente().equalsIgnoreCase(codigoCliente)){
                lista.add(p);
            }
        }
        return lista;
    }

    public static void main(String[] args){
        cargarDatos();

        Scanner sc= new Scanner(System.in);
        System.out.println("=====INICIO SESION=====");
        System.out.println("Usuario: ");
        String user= sc.nextLine();
        System.out.println("Contraseña: ");
        String contrasena= sc.nextLine();

        Usuario uInicioSesion= null;
        for (Usuario u: usuarios){
            if (u.getUsuario().equals(user) && u.getContrasenia().equals(contrasena)){
                uInicioSesion= u;
                break;
            }
        }

        if (uInicioSesion==null){
            System.out.println("Credenciales incorrectas. Cerrando sesión.");
            return;
        }
        
        if (uInicioSesion instanceof Cliente cliente){
            System.out.println("Bienvenido, "+cliente.getNombres());
            while (true){
                System.out.println("\n1. Comprar producto\n2. Consultar pedidos\n3. Salir");
                System.out.println("Seleccione una opción: ");
                int opcion= Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        ClienteServicio.iniciarCompra(cliente, productos, obtenerRepartidors());
                        break;
                    case 2:
                        cliente.gestionarPedido();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } else if (uInicioSesion instanceof Repartidor rep){
            System.out.println("\nBienvenido repartidor: "+ rep.getNombres());
            rep.gestionarPedido();
        }
    }

    public static void cargarDatos(){
        Cliente cliente= new Cliente("CL001", "12381798", "Ana", "Torres", "atorres", "1234", "ana@mail.com", Rol.CLIENTE, "0999999999", "Calle 123");
        Repartidor rep= new Repartidor("RP001", "0931909584", "Luis", "Medina","lmedina", "abcd", "luis@mail.com", Rol.REPARTIDOR, "Uber");
        agregarUsuario(cliente);
        agregarUsuario(rep);

        agregarProducto(new Producto("P001", "Audífonos", 25.5, 15, Categoria.TECNOLOGIA));
        agregarProducto(new Producto("P002", "Camiseta", 12.0, 20, Categoria.ROPA));
    }
}    