package com.proyecto;
/**
 * Enum que representa las formas de pago disponibles en el sistema.
 *
 * Las opciones disponibles son:
 * <ul>
 *   <li>{@code TARJETA} – Pago realizado mediante tarjeta de crédito o débito.</li>
 *   <li>{@code EFECTIVO} – Pago realizado en dinero en efectivo.</li>
 * </ul>
 *
 * Este enum permite que el sistema maneje diferentes métodos de pago
 * de manera organizada y extensible.
 *
 * @author Paola Reyes
 */
public enum FormaPago {
    /**
     * Pago realizado con tarjeta de crédito o débito.
     */
    TARJETA,
    /**
     * Pago realizado en efectivo.
     */
    EFECTIVO
}
