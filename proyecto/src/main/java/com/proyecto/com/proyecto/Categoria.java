package com.proyecto;

/**
 * Enum que representa las diferentes categorías de productos disponibles en el sistema.
 *
 * Las categorías permiten clasificar los productos de forma organizada:
 * <ul>
 *   <li>{@code ROPA} – Prendas de vestir y accesorios.</li>
 *   <li>{@code TECNOLOGIA} – Equipos electrónicos y dispositivos tecnológicos.</li>
 *   <li>{@code DEPORTE} – Artículos deportivos y de actividad física.</li>
 *   <li>{@code HOGAR} – Productos para el hogar y uso doméstico.</li>
 * </ul>
 *
 * Este enum se utiliza para filtrar y mostrar productos según su tipo.
 *
 * @author Daniela Bozza
 */
public enum Categoria {
    /**
     * Categoría de prendas de vestir.
     */
    ROPA,
    /**
     * Categoría de productos tecnológicos.
     */
    TECNOLOGIA,
    /**
     * Categoría de artículos deportivos.
     */
    DEPORTE,
    /**
     * Categoría de productos para el hogar.
     */
    HOGAR
}
