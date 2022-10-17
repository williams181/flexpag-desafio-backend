package com.flexpag.paymentscheduler.agendamento.enums;

import lombok.Getter;

public enum EnumStatusAgendamento {
    
    PENDENTE(1, "PENDENTE"),
    PAGO(2, "PAGO");

    private EnumStatusAgendamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;
}
