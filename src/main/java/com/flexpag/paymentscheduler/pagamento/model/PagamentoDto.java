package com.flexpag.paymentscheduler.pagamento.model;

import java.time.LocalDate;

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

    private Long idImovel;

    @NotNull
    private String descricao;

    @NotBlank(message = "O status do pagametento não pode ser vazio.")
    private String statusPagamento;

    @NotNull
    private LocalDate validadePromocao;

    @NotNull
    private Double valorPagamento;
}
