package com.flexpag.paymentscheduler.pagamento.enums;

import lombok.Getter;

public enum EnumStatusPagamento {
    
    PAGO(1, "Pago"),
    PENDENTE(2, "Pendente");

    private EnumStatusPagamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;
    
    @Getter
    private String descricao;
}
