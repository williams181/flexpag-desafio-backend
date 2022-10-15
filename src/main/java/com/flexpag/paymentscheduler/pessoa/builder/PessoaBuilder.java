package com.flexpag.paymentscheduler.pessoa.builder;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.flexpag.paymentscheduler.pessoa.model.Pessoa;
import com.flexpag.paymentscheduler.pessoa.model.PessoaDto;
import com.flexpag.paymentscheduler.usuario.model.Usuario;

@Component
public class PessoaBuilder {

    public PessoaDto builderDto(Pessoa pessoa) {
        if(Objects.isNull(pessoa)) {
            return null;
        }
        return PessoaDto.builder()
                .idPessoa(pessoa.getIdPessoa())
                .cnpj(pessoa.getCnpj())
                .cpf(pessoa.getCpf())
                .dataNascimento(pessoa.getDataNascimento())
                .nome(pessoa.getNome())
                .telefone(pessoa.getTelefone())
                .usuarioId(pessoa.getUsuario().getIdUsuario())
                .build();
    }

    public Pessoa builderModel(PessoaDto pessoaDto, Usuario usuario) {
        return Pessoa.builder()
                .cnpj(pessoaDto.getCnpj())
                .cpf(pessoaDto.getCpf())
                .dataNascimento(pessoaDto.getDataNascimento())
                .nome(pessoaDto.getNome())
                .telefone(pessoaDto.getTelefone())
                .usuario(usuario)
                .build();
    }

}
