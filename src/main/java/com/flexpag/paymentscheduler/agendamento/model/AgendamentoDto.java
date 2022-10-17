package com.flexpag.paymentscheduler.agendamento.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDto {
    
    @JsonProperty(value = "Agendamento_id")
    private Long idAgendamento;

    @NotNull(message = "O usuário deve ser informado.")
    @JsonProperty(value = "usuario_id")
    private Long idUsuarioFK;

    @Column(name = "valor_pagamento")
    private Double valorPagamento;
    
    @Column(name = "data_agendamento")
    private LocalDateTime dataAgendamento;
    
    @Column(name = "STATUS_PAGAMENTO")
    private Boolean statusPagamento;

    @NotNull(message = "O status do agendamento não pode ser vazio.")
    @JsonProperty(value = "status_agendamento")
    private String statusAgendamento;
}
