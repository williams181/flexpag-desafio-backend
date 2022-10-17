package com.flexpag.paymentscheduler.agendamento.builder;

import org.springframework.stereotype.Component;

import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.agendamento.model.EnumStatusAgendamento;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;
import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;
import com.flexpag.paymentscheduler.usuario.model.Usuario;

@Component
public class AgendamentoBuilder {

    public AgendamentoDto builderDto(Agendamento agendamento) {
        return AgendamentoDto.builder()
                .idAgendamento(agendamento.getIdAgendamento())
                .idPagamentoFK(agendamento.getIdPagamentoFK().getIdPagamento())
                .idUsuarioFK(agendamento.getIdUsuarioFK().getIdUsuario())
                .statusAgendamento(agendamento.getStatusAgendamento().getDescricao())
                .build();
    }

    public Agendamento builderModel(AgendamentoDto agendamentoDto, Pagamento pagamento, Usuario usuario, EnumStatusAgendamento statusAgendamento) {
        return Agendamento.builder()
                .idUsuarioFK(usuario)
                .idPagamentoFK(pagamento)
                .statusAgendamento(statusAgendamento)
                .build();
    }
}
