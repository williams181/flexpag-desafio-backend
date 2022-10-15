package com.flexpag.paymentscheduler.pagamento.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flexpag.paymentscheduler.pagamento.enums.EnumStatusPagamento;
import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PAGAMENTO")
@Entity
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idPagamento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_Pagamento")
    private Double valorPagamento;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "STATUS_PAGAMENTO")
    @Enumerated(EnumType.STRING)
    private EnumStatusPagamento statusApagamento;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa idPessoa;

}
