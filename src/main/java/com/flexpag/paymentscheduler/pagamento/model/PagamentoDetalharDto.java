package com.flexpag.paymentscheduler.pagamento.model;

import com.flexpag.paymentscheduler.pagamento.model.PagamentoDetalharDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDetalharDto {
    
    private Long idPagamento;
    
    private Double valorPagamento;

}
