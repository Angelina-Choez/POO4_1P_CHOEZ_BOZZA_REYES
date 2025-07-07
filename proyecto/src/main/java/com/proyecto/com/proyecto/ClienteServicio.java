package com.proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ClienteServicio {
    public static Pedido iniciarCompra(Cliente cliente, List<Producto> productos, List<Repartidor> repartidores) {
        Categoria categoria = seleccionarCategoria();
        if (categoria == null) return null;

        List<Producto> disponibles = filtrarProductos(productos, categoria);
        if (disponibles.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return null;
        }

        mostrarProductos(disponibles);
        Producto seleccionado = seleccionarProducto(disponibles);
        if (seleccionado == null) return null;

        int cantidad = solicitarCantidad(seleccionado);
        if (cantidad <= 0) return null;

        double total = cantidad * seleccionado.getPrecio();
        System.out.printf("Total a pagar: $%.2f\n", total);

        FormaPago tipo = seleccionarFormaPago();
        System.out.print("Ingrese referencia de pago: ");
        String ref = sc.nextLine();
        Pago pago = new Pago(tipo, ref, total);
        pago.procesar();

        if (!pago.estaVerificado()) {
            System.out.println("Pago no verificado.");
            return null;
        }

        Repartidor repartidor = elegirRepartidor(repartidores);
        if (repartidor == null) return null;

        Pedido pedido = cliente.generarPedido(seleccionado, cantidad, pago, repartidor);
        Sistema.agregarPedido(pedido);
        System.out.println("Pedido creado con éxito: " + pedido.getCodigoPedido());
        return pedido;
    }

    private static Categoria seleccionarCategoria() {
        System.out.println("\nCategorías:");
        for (Categoria c : Categoria.values()) System.out.println("- " + c.name());
        System.out.print("Seleccione categoría: ");
        try {
            return Categoria.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Categoría inválida.");
            return null;
        }
    }

    private static List<Producto> filtrarProductos(List<Producto> productos, Categoria categoria) {
        List<Producto> lista = new ArrayList<>();
        for (Producto p : productos)
            if (p.getCategoria() == categoria && p.getStock() > 0) lista.add(p);
        return lista;
    }

    private static void mostrarProductos(List<Producto> productos) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.printf("%d. %s ($%.2f, Stock: %d)\n", i + 1, p.getNombre(), p.getPrecio(), p.getStock());
        }
    }

    private static Producto seleccionarProducto(List<Producto> disponibles) {
        System.out.print("Elija número de producto: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion >= 1 && opcion <= disponibles.size()) return disponibles.get(opcion - 1);
        } catch (Exception ignored) {}
        System.out.println("Opción inválida.");
        return null;
    }

    private static int solicitarCantidad(Producto p) {
        System.out.print("Cantidad a comprar: ");
        try {
            int cantidad = Integer.parseInt(sc.nextLine());
            if (cantidad > 0 && p.estaDisponible(cantidad)) return cantidad;
        } catch (Exception ignored) {}
        System.out.println("Cantidad inválida o stock insuficiente.");
        return -1;
    }

    private static FormaPago seleccionarTipoPago() {
        System.out.println("Métodos de pago:");
        for (FormaPago t : FormaPago.values()) System.out.println("- " + t.name());
        System.out.print("Seleccione uno: ");
        try {
            return FormaPago.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Pago no válido. Se usará TARJETA.");
            return FormaPago.TARJETA;
        }
    }

    private static Repartidor elegirRepartidor(List<Repartidor> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay repartidores.");
            return null;
        }
        return lista.get((int) (Math.random() * lista.size()));
    }
}
