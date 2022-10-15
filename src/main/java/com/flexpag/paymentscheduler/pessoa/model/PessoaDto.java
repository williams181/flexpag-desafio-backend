package com.flexpag.paymentscheduler.pessoa.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import com.flexpag.paymentscheduler.pessoa.model.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    @JsonProperty(value = "pessoa_id")
    private Long idPessoa;
    
    @NotBlank(message = "O nome não pode estar em branco.")
    @JsonProperty(value = "nome")
    private String nome;

    @NotNull(message = "A data de nascimento deve ser fornecida.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty(value = "data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "cnpj")
    private String cnpj;

    @NotBlank(message = "O telefone deve ser fornecido.")
    @JsonProperty(value = "telefone")
    private String telefone;

    @NotNull(message = "Os dados de cadastro devem estar relacionados a um usuário.")
    @JsonProperty(value = "usuario_id")
    public Long usuarioId;
}
