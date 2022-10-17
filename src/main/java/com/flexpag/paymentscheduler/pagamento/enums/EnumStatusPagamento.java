package com.flexpag.paymentscheduler.pagamento.enums;

import lombok.Getter;

public enum EnumStatusPagamento {
    
    PENDENTE(1, "Pendente"),
    PAGO(2, "Pago");
    

    private EnumStatusPagamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;
    
    @Getter
    private String descricao;
}
