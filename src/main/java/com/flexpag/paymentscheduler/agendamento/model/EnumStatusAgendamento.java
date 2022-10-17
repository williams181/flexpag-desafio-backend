package com.flexpag.paymentscheduler.agendamento.model;

import lombok.Getter;

public enum EnumStatusAgendamento {
    
    PENDENTE(1, "Pendente"),
    PAGO(2, "Pago");

    private EnumStatusAgendamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;
}
