package com.proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        return null;
    }

    public static List<Repartidor> obtenerRepartidores(){
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
        return null;
    }

    public static void agregarProducto(Producto producto){
        if (producto !=null && buscarProductoPorCodigo(producto.getCodigo())==null){
            productos.add(producto);
        }else{
            System.out.println("El producto ya existe o es nulo.");
        }
    }

    public static List<Producto> obtenerProductos(){
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
        return null;
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
    public class Main {
            public static void main(String[] args) {
        cargarDatos(); // Método para agregar datos de prueba

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== INICIO DE SESIÓN =====");
        System.out.print("Usuario: ");
        String usuarioInput = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasenaInput = scanner.nextLine();

        Usuario encontrado = null;
        for (Usuario u : Sistema.obtenerUsuarios()) {
            if (u.getUsuario().equals(usuarioInput) && u.getContrasenia().equals(contrasenaInput)) {
                encontrado = u;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Credenciales incorrectas. Saliendo...");
            return;
        }

        System.out.println("Usuario autenticado correctamente.");
        System.out.println("Rol detectado: " + encontrado.getRol());

        if (encontrado instanceof Cliente) {
            Cliente cliente = (Cliente) encontrado;
            System.out.println("Bienvenido, " + cliente.getNombres() + " " + cliente.getApellidos());
            System.out.println("Celular registrado: " + cliente.getCelular());
            System.out.print("¿Este número es correcto? (S/N): ");
            String confirmacion = scanner.nextLine();
            if (!confirmacion.equalsIgnoreCase("S")) {
                System.out.println("Verificación fallida. Cerrando sesión.");
                return;
            }

            mostrarMenuCliente(cliente, scanner);

        } else if (encontrado instanceof Repartidor) {
            Repartidor rep = (Repartidor) encontrado;
            System.out.println("Bienvenido, " + rep.getNombres());
            System.out.println("Empresa asignada: " + rep.getEmpresa());
            System.out.print("¿Esta empresa es correcta? (S/N): ");
            String confirmacion = scanner.nextLine();
            if (!confirmacion.equalsIgnoreCase("S")) {
                System.out.println("Verificación fallida. Cerrando sesión.");
                return;
            }

            mostrarMenuRepartidor(rep);
        }
    }

    private static void mostrarMenuCliente(Cliente cliente, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de Cliente:");
            System.out.println("1. Comprar producto");
            System.out.println("2. Gestionar pedido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->ClienteServicio.seleccionarProducto(Sistema.obtenerProductos(), cliente);
                case 2 -> cliente.gestionarPedido();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenuRepartidor(Repartidor rep) {
        System.out.println("Menú de Repartidor:");
        rep.gestionarPedido();
    }

    private static void cargarDatos() {
        
        Cliente cliente = new Cliente("CL001", "0991234567", "Ana", "Torres", "atorres", "1234", "ana@mail.com", null, "0991234567", "Calle 1");
        Repartidor repartidor = new Repartidor("RP001", "0101010101", "Luis", "Medina", "lmedina", "abcd", "luis@mail.com", null, "Envios Express");

        Sistema.agregarUsuario(cliente);
        Sistema.agregarUsuario(repartidor);

    
        Producto p1 = new Producto("P001", "Zapatillas", 50.0, 10, Categoria.DEPORTE);
        Producto p2 = new Producto("P002", "Laptop HP", 600.0, 5, Categoria.TECNOLOGIA);
        Sistema.agregarProducto(p1);
        Sistema.agregarProducto(p2);
    }
}
}
