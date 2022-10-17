package com.flexpag.paymentscheduler.agendamento.model;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.flexpag.paymentscheduler.usuario.model.Usuario;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;
import com.flexpag.paymentscheduler.agendamento.enums.EnumStatusAgendamento;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idAgendamento;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario idUsuarioFK;

    @Column(name = "valor_pagamento")
    private Double valorPagamento;
    
    @Column(name = "data_agendamento")
    private LocalDateTime dataAgendamento;
    
    @Column(name = "STATUS_PAGAMENTO")
    private Boolean statusPagamento;

    @Column(name = "STATUS_AGENDAMENTO")
    @Enumerated(EnumType.STRING)
    private EnumStatusAgendamento statusAgendamento;
}