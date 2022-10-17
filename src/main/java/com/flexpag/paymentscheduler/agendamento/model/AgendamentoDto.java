package com.flexpag.paymentscheduler.agendamento.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull(message = "O pagamento deve ser informado.")
    @JsonProperty(value = "pagamento_id")
    private Long idPagamentoFK;

    @NotNull(message = "O status do agendamento não pode ser vazio.")
    @JsonProperty(value = "status_agendamento")
    private String statusAgendamento;
}
