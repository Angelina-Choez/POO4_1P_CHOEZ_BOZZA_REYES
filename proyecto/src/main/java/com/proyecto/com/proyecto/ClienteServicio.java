package com.proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ClienteServicio {
    
    public static Pedido iniciarCompra(Cliente cliente, List<Producto> productos, List<Repartidor> repartidores) {
        Scanner sc= new Scanner(System.in);
        System.out.println("=====PROCESO DE COMPRA=====");
        
        System.out.println("Categorías disponibles: ");
        for (Categoria c: Categoria.values()){
            System.out.println("- "+c);
        }

        System.out.println("Seleccione una categoría: ");
        Categoria categoria;
        try{
            categoria= Categoria.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e){
            System.out.println("Categoría no válida.");
            return null;
        }

        List<Producto> disponibles= new ArrayList<>();
        for (Producto p: productos){
            if (p.getCategoria()== categoria && p.getStock() > 0){
                disponibles.add(p);
            }
        }

        if (disponibles.isEmpty()){
            System.out.println("No hay productos disponibles en esta categoría.");
            return null;
        }

        System.out.println("Productos disponibles: ");
        for (int i=0; i< disponibles.size(); i++){
            System.out.println((i+1)+ "." + disponibles.get(i));
        }

        System.out.println("Seleccione el número del producto: ");
        int opcionProducto= Integer.parseInt(sc.nextLine());
        if (opcionProducto< 1 || opcionProducto>disponibles.size()){
            System.out.println("Opción válida.");
            return null;
        }

        Producto seleccionado= disponibles.get(opcionProducto-1);

        System.out.println("Ingrese la cantidad a comprar: ");
        int cantidad= Integer.parseInt(sc.nextLine());

        if (!seleccionado.estaDisponible(cantidad)){
            System.out.println("Stock insufiencte.");
            return null;
        }

        double total= seleccionado.getPrecio()*cantidad;
        System.out.printf("Total a pagar: $%.2f\\n", total);

        System.out.println("Formas de pago: ");
        for (FormaPago fp: FormaPago.values()){
            System.out.println("- "+fp);
        }
        System.out.println("Seleccione forma de pago: ");
        FormaPago formaPago;
        try{
            formaPago= FormaPago.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e){
            System.out.println("Forma de pago no válida. Se usará TARJETA por defecto.");
            formaPago= FormaPago.TARJETA;
        }

        System.out.println("Ingrese referencia de pago: ");
        String referencia= sc.nextLine();
        Pago pago= new Pago(referencia, total, formaPago);
        pago.procesar();

        if (!pago.isVerificado()){
            System.out.println("Pago no verificado. Cancelando compra.");
            return null;
        }

        Repartidor repartidor= repartidores.get(0);

        Pedido pedido= cliente.generarPedido(seleccionado, cantidad, pago, repartidor);
        if (pedido!= null){
            Sistema.agregarPedido(pedido);
            System.out.println("Pedido agregado exitosamente: "+pedido.getCodigoPedido());
        } else{
            System.out.println("Error al generar pedido.");
        }
        return pedido;
    }

    public static void consultarEstadoPedido(Cliente cliente){
        List <Pedido> pedidosCliente = Sistema.obtenerPedidosPorCliente(cliente.getCodigoUnico());

        if (pedidosCliente.isEmpty()){
            System.out.println("No tiene pedidos registrados");
        }
        System.out.println("=====SUS PEDIDOS=====");
        for (Pedido p: pedidosCliente){
            System.out.println(p);
        }
    }
}