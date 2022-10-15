package com.flexpag.paymentscheduler.pagamento.model;

import java.time.LocalDate;

import com.flexpag.paymentscheduler.pagamento.enums.EnumStatusPagamento;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoListaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoListaDto {
    
    private Long idImovel;
    private String descricao;
    private Double valorPagamento;
    private LocalDate dataAgendamento;
    private EnumStatusPagamento statusApagamento;

}
