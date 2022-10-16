package com.flexpag.paymentscheduler.pagamento.builder;

import org.springframework.stereotype.Component;

import com.flexpag.paymentscheduler.pagamento.enums.EnumStatusPagamento;
import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDetalharDto;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDto;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoListaDto;

@Component
public class PagamentoBuilder {

    public PagamentoDto builderDto(Pagamento pagamento){
        return PagamentoDto.builder()
                .idPagamento(pagamento.getIdPagamento())
                .valorPagamento(pagamento.getValorPagamento())
                .build();
            }

    public Pagamento builderModel(PagamentoDto pagamentoDto, EnumStatusPagamento statusPagamento){
        return Pagamento.builder()
        .statusPagamento(statusPagamento)
        .valorPagamento(pagamentoDto.getValorPagamento())
        .build();
    }

    public PagamentoListaDto buiderPagamentoListagem(Pagamento pagamento) {
        return PagamentoListaDto.builder()
            .idPagamento(pagamento.getIdPagamento())
            .valorPagamento(pagamento.getValorPagamento())
            .statusPagamento(pagamento.getStatusPagamento())
            .build();
    }

  
}
