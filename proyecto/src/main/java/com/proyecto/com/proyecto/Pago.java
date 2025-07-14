package com.proyecto;
/**
 * Clase que representa un pago realizado por un cliente.
 * Contiene información sobre la forma de pago, referencia, monto y si fue verificado.
 * La verificación depende del tipo de forma de pago utilizada.
 *
 * @author Paola Reyes
 */
public class Pago {
    private FormaPago formaPago;
    private String referencia;
    private double monto;
    private boolean verificado;
    /**
     * Constructor de la clase Pago.
     *
     * @param referencia Código o descripción del pago
     * @param monto      Monto pagado
     * @param formaPago  Forma en que se realiza el pago (TARJETA o EFECTIVO)
     */

    public Pago(String referencia, double monto, FormaPago formaPago){
        this.formaPago=formaPago;
        this.referencia=referencia;
        this.monto= monto;
        this.verificado=false;
    }
    /**
     * Procesa el pago y lo verifica según la forma de pago:
     * <ul>
     *   <li>TARJETA: válido si la referencia tiene al menos 8 caracteres.</li>
     *   <li>EFECTIVO: válido si la referencia no es nula ni vacía.</li>
     * </ul>
     */

    public void procesar(){
        if (formaPago==FormaPago.TARJETA){
            this.verificado= referencia.length()>=8;
        }else if (formaPago==FormaPago.EFECTIVO){
            this.verificado= referencia != null && !referencia.isEmpty();
        }else{
            this.verificado= false;
        }
    }
    /**
     * Obtiene la forma de pago.
     *
     * @return forma de pago
     */
    public FormaPago getFormaPago() {
        return formaPago;
    }
    /**
     * Establece la forma de pago.
     *
     * @param formaPago Forma de pago (TARJETA o EFECTIVO)
     */
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    /**
     * Obtiene la referencia del pago.
     *
     * @return referencia
     */
    public String getReferencia() {
        return referencia;
    }
    /**
     * Establece la referencia del pago.
     *
     * @param referencia Referencia o código del pago
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    /**
     * Obtiene el monto del pago.
     *
     * @return monto pagado
     */
    public double getMonto() {
        return monto;
    }
    /**
     * Establece el monto del pago.
     *
     * @param monto Valor del pago
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    /**
     * Indica si el pago ha sido verificado.
     *
     * @return true si el pago fue verificado, false si no
     */
    public boolean isVerificado() {
        return verificado;
    }
    /**
     * Establece el estado de verificación del pago.
     *
     * @param verificado true si fue verificado correctamente
     */
    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
    
}
