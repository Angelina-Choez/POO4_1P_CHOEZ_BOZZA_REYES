package com.proyecto;

public class Pago {
    private FormaPago formaPago;
    private String referencia;
    private double monto;
    private boolean verificado;
    
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isVerificado() {
        return verificado;
    }
    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
    public Pago(String referencia, double monto, FormaPago formaPago){
        this.formaPago=formaPago;
        this.referencia=referencia;
        this.monto= monto;
        this.verificado=false;
    }
    public void procesar() {
        if (formaPago == FormaPago.TRANSFERENCIA) {
            this.verificado = referencia != null && !referencia.isEmpty();
        } else if (formaPago == FormaPago.TARJETA) {
            this.verificado = referencia != null && referencia.length() >= 8; // ejemplo simple
        } else {
            this.verificado = true;
        }
    }

    
}
