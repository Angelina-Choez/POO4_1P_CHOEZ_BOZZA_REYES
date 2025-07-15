package com.proyecto;
/**
 * Enum que representa los roles disponibles en el sistema.
 * Puede ser un {@code CLIENTE} o un {@code REPARTIDOR}.
 *
 * Se utiliza para distinguir el tipo de usuario en el sistema.
 *
 * @author Daniela Bozza
 */
public enum Rol {
    /**
     * Rol asignado a los usuarios que realizan compras.
     */
    CLIENTE,
    
    /**
     * Rol asignado a los usuarios encargados de entregar los pedidos.
     */
    REPARTIDOR
}
