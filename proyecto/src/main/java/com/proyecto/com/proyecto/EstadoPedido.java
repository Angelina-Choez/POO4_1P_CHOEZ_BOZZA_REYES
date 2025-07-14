package com.proyecto;
/**
 * Enum que representa los posibles estados de un pedido en el sistema.
 *
 * Los estados permiten realizar el seguimiento del ciclo de vida de un pedido.
 * <ul>
 *   <li>{@code EN_PREPARACION} – El pedido está siendo preparado.</li>
 *   <li>{@code EN_RUTA} – El pedido ya ha salido y está en camino al cliente.</li>
 *   <li>{@code ENTREGADO} – El pedido ha sido entregado al cliente.</li>
 * </ul>
 *
 * Este enum se utiliza para gestionar y actualizar el estado de los pedidos.
 *
 * @author Daniela Bozza
 */
public enum EstadoPedido {
    /**
     * El pedido está en proceso de preparación.
     */
    EN_PREPARACION,
    /**
     * El pedido ha salido y está en camino.
     */
    EN_RUTA,
    /**
     * El pedido ha sido entregado al cliente.
     */
    ENTREGADO
}
