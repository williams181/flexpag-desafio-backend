package com.flexpag.paymentscheduler.agendamento.builder;

import org.springframework.stereotype.Component;
import com.flexpag.paymentscheduler.usuario.model.Usuario;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;
import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;
import com.flexpag.paymentscheduler.agendamento.enums.EnumStatusAgendamento;

@Component
public class AgendamentoBuilder {

    public AgendamentoDto builderDto(Agendamento agendamento) {
        return AgendamentoDto.builder()
                .idAgendamento(agendamento.getIdAgendamento())
                .valorPagamento(agendamento.getValorPagamento())
                .statusPagamento(agendamento.getStatusPagamento())
                .idUsuarioFK(agendamento.getIdUsuarioFK().getIdUsuario())
                .dataAgendamento(agendamento.getDataAgendamento())
                .statusAgendamento(agendamento.getStatusAgendamento().getDescricao())
                .build();
    }

    public Agendamento builderModel(AgendamentoDto agendamentoDto, Usuario usuario, EnumStatusAgendamento statusAgendamento) {
        return Agendamento.builder()
                .idUsuarioFK(usuario)
                .valorPagamento(agendamentoDto.getValorPagamento())
                .statusPagamento(agendamentoDto.getStatusPagamento())
                .dataAgendamento(agendamentoDto.getDataAgendamento())
                .statusAgendamento(statusAgendamento)
                .build();
    }
}
