package com.flexpag.paymentscheduler.pagamento.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDto {

    private Long idPagamento;

    @NotNull
    private Double valorPagamento;
    
    @NotBlank(message = "O status do pagametento não pode ser vazio.")
    private String statusPagamento;

}
