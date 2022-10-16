package com.flexpag.paymentscheduler.pagamento.enums;

import lombok.Getter;

public enum EnumStatusPagamento {
    
    PAGO("Pago"),
    PENDENTE("Pendente");

    private EnumStatusPagamento(String descricao) {

        this.descricao = descricao;
    }

    @Getter
    private String descricao;
}
