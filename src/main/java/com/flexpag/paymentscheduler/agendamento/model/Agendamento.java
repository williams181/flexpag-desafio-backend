package com.flexpag.paymentscheduler.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.usuario.model.Usuario;

import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.agendamento.model.EnumStatusAgendamento;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(name = "PAGAMENTO_ID")
    private Pagamento idPagamentoFK;

    @Column(name = "STATUS_AGENDAMENTO")
    @Enumerated(EnumType.STRING)
    private EnumStatusAgendamento statusAgendamento;
}