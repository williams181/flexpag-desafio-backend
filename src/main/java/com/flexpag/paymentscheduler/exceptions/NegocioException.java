package com.flexpag.paymentscheduler.exceptions;

public class NegocioException extends Exception {

    private String mensagem;

    public NegocioException(String message, String mensagem) {
        super(message);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
