package com.proyecto;
import java.time.LocalDate;
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
    public static Usuario buscarUsuarioPorCodigo(String codigo) {
        for (Usuario u : usuarios) {
            if (u.getCodigoUnico().equalsIgnoreCase(codigo)) {
                return u;
        }
        }
        return null;
        }
    public static void notificar(Cliente cliente, Pedido pedido) {
        System.out.println("\n[NOTIFICACIÓN A CLIENTE]");
        System.out.println("Para: " + cliente.getCorreo());
        System.out.println("Asunto: Confirmación de pedido");
        System.out.println("Hola " + cliente.getNombres() + ",");
        System.out.println("Su pedido con código " + pedido.getCodigoPedido() + " ha sido registrado correctamente.");
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.printf("Monto: $%.2f\n", pedido.getValorPagado());
        System.out.println("Estado actual: " + pedido.getEstado());
        System.out.println("¡Gracias por su compra!");
        }

    public static void notificar(Repartidor repartidor, Pedido pedidoAsignado) {
        System.out.println("\n[NOTIFICACIÓN A REPARTIDOR]");
        System.out.println("Para: " + repartidor.getCorreo());
        System.out.println("Asunto: Nuevo pedido asignado");
        System.out.println("Estimado " + repartidor.getNombres() + ",");
        System.out.println("Se le ha asignado el pedido " + pedidoAsignado.getCodigoPedido());
        System.out.println("Debe preparar el envío para el cliente con código: " + pedidoAsignado.getCodigoCliente());
        System.out.println("Fecha de asignación: " + pedidoAsignado.getFecha());
        System.out.println("Por favor revise su bandeja de entregas.");
        }

    public static void notificar(Cliente cliente, Pedido pedido, EstadoPedido nuevoEstado) {
        System.out.println("\n[NOTIFICACIÓN DE CAMBIO DE ESTADO]");
        System.out.println("Para: " + cliente.getCorreo());
        System.out.println("Asunto: Estado actualizado de su pedido");
        System.out.println("Hola " + cliente.getNombres() + ",");
        System.out.println("Su pedido con código " + pedido.getCodigoPedido() + " ha cambiado de estado.");
        System.out.println("Nuevo estado: " + nuevoEstado);
        System.out.println("Fecha: " + LocalDate.now());
        System.out.println("Gracias por confiar en nuestro servicio.");
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

    public static void cargarUsuariosDesdeArchivo(String ruta) {
        List<String> lineas = ManejoArchivos.leerArchivo(ruta);
        for (String linea : lineas) {
            String[] p = linea.split(";");
            if (p.length == 10 && p[7].equalsIgnoreCase("CLIENTE")) {
                Cliente c = new Cliente(p[0], p[1], p[2], p[3], p[4], p[5], p[6], Rol.CLIENTE, p[8], p[9]);
                agregarUsuario(c);
            } else if (p.length == 9 && p[7].equalsIgnoreCase("REPARTIDOR")) {
                Repartidor r = new Repartidor(p[0], p[1], p[2], p[3], p[4], p[5], p[6], Rol.REPARTIDOR, p[8]);
                agregarUsuario(r);
            }
        }
    }

    public static void cargarProductosDesdeArchivo(String ruta) {
        List<String> lineas = ManejoArchivos.leerArchivo(ruta);
        for (String linea : lineas) {
            String[] p = linea.split(";");
            if (p.length == 5) {
                Producto pr = new Producto(p[0], p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3]), Categoria.valueOf(p[4]));
                agregarProducto(pr);
            }
        }
    }

    public static void cargarPedidosDesdeArchivo(String ruta) {
        List<String> lineas = ManejoArchivos.leerArchivo(ruta);
        for (String linea : lineas) {
            String[] p = linea.split(";");
            if (p.length >= 11) {
                Pago pago = new Pago(p[9], Double.parseDouble(p[10]), FormaPago.valueOf(p[8]));
                Pedido pedido = new Pedido(p[0], LocalDate.parse(p[1]), p[2], Integer.parseInt(p[3]),Double.parseDouble(p[4]), EstadoPedido.valueOf(p[5]),p[6], p[7], pago);
                pedidos.add(pedido);
            }
        }
    }
    public static void actualizarArchivoPedidos() {
        List<String> nuevasLineas = new ArrayList<>();
        for (Pedido p : pedidos) {
            nuevasLineas.add(p.toArchivo());
        }
        ManejoArchivos.sobrescribirArchivo("pedidos.txt", nuevasLineas);
        }



    public static void cargarDatos() {
        cargarUsuariosDesdeArchivo("clientes.txt");
        cargarUsuariosDesdeArchivo("repartidores.txt");
        cargarProductosDesdeArchivo("productos.txt");
        cargarPedidosDesdeArchivo("pedidos.txt");
    }

    public static void main(String[] args) {
        cargarDatos();

        Scanner sc = new Scanner(System.in);
while (true) {
    System.out.println("===== INICIO DE SESIÓN =====");
    System.out.print("Usuario: ");
    String user = sc.nextLine();
    System.out.print("Contraseña: ");
    String contrasena = sc.nextLine();

    Usuario uInicioSesion = null;
    for (Usuario u : usuarios) {
        if (u.getUsuario().equals(user) && u.getContrasenia().equals(contrasena)) {
            uInicioSesion = u;
            break;
        }
    }

    if (uInicioSesion == null) {
        System.out.println("Credenciales incorrectas. ¿Desea intentar otra vez? (S/N): ");
        String op = sc.nextLine();
        if (!op.equalsIgnoreCase("S")) {
            System.out.println("Saliendo del sistema...");
            break;
        } else {
            continue; // vuelve a pedir usuario/contraseña
        }
    }

    // Si es Cliente
    if (uInicioSesion instanceof Cliente cliente) {
        System.out.println("\nBienvenido/a, " + cliente.getNombres() + " " + cliente.getApellidos());
        System.out.println("Celular registrado: " + cliente.getCelular());
        System.out.print("¿Este número es correcto? (S/N): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("S")) {
            System.out.println("Verificación fallida. Se cerrará la sesión por seguridad.");
            continue; // volver a inicio de sesión
        }

        while (true) {
            System.out.println("\n===== MENÚ CLIENTE =====");
            System.out.println("1. Comprar producto");
            System.out.println("2. Consultar estado de pedido");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> ClienteServicio.iniciarCompra(cliente, productos, obtenerRepartidors());
                case 2 -> cliente.gestionarPedido();
                case 3 -> {
                    System.out.println("Cerrando sesión...");
                    uInicioSesion = null;
                    break;
                }
                default -> System.out.println("Opción no válida.");
            }

            if (opcion == 3) break; // rompe solo el menú de cliente
        }
    }

    // Si es Repartidor
    else if (uInicioSesion instanceof Repartidor rep) {
        System.out.println("\nBienvenido repartidor: " + rep.getNombres() + " " + rep.getApellidos());
        System.out.println("Empresa asignada: " + rep.getEmpresa());
        System.out.print("¿Esta empresa es correcta? (S/N): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("S")) {
            System.out.println("Verificación fallida. Se cerrará la sesión por seguridad.");
            continue; // volver a login
        }

        // Menú para repartidor si deseas extender
        while (true) {
            System.out.println("\n===== MENÚ REPARTIDOR =====");
            System.out.println("1. Ver pedidos asignados");
            System.out.println("2. Cambiar estado de un pedido");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int op;
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }
            switch (op) {
        case 1 -> {
            System.out.println("\nPedidos asignados a usted:");
            boolean tiene = false;
            for (Pedido p : pedidos) {
                if (p.getCodigoRepartidor().equals(rep.getCodigoUnico())) {
                    System.out.println("Código: " + p.getCodigoPedido() +
                        ", Cliente: " + p.getCodigoCliente() +
                        ", Estado: " + p.getEstado());
                    tiene = true;
                }
            }
            if (!tiene) {
                System.out.println("No tiene pedidos asignados.");
            }
        }
        case 2 -> {
            System.out.print("Ingrese el código del pedido a actualizar: ");
            String codigo = sc.nextLine();
            Pedido pedido = buscarPedidoPorCodigo(codigo);
            if (pedido == null || !pedido.getCodigoRepartidor().equals(rep.getCodigoUnico())) {
                System.out.println("Pedido no encontrado o no está asignado a usted.");
            } else {
                System.out.println("Estado actual: " + pedido.getEstado());
                System.out.println("Estados disponibles:");
                for (EstadoPedido est : EstadoPedido.values()) {
                    System.out.println("- " + est);
                }
                System.out.print("Ingrese el nuevo estado: ");
                String nuevo = sc.nextLine().toUpperCase();
                try {
                    EstadoPedido nuevoEstado = EstadoPedido.valueOf(nuevo);
                    if (pedido.getEstado() == EstadoPedido.EN_PREPARACION && nuevoEstado == EstadoPedido.ENTREGADO) {
                        System.out.println("No puede saltar directamente de EN_PREPARACION a ENTREGADO.");
                    } else {
                        pedido.setEstado(nuevoEstado);
                        actualizarArchivoPedidos(); // para guardar el cambio
                        System.out.println("Estado actualizado.");
                        Cliente cliente = (Cliente) buscarUsuarioPorCodigo(pedido.getCodigoCliente());
                        if (cliente != null) {
                            notificar(cliente, pedido, nuevoEstado);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Estado inválido.");
                }
            }
        }
        case 3 -> {
            System.out.println("Cerrando sesión...");
            break;
        }
        default -> System.out.println("Opción inválida.");
    }
    if (op ==3)break;
        }
    }
}

// Fuera del while: sale del sistema
System.out.println("Gracias por usar el sistema.");

    }
}