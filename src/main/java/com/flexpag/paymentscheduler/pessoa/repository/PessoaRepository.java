package com.flexpag.paymentscheduler.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flexpag.paymentscheduler.pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.usuario.idUsuario = :idUsuario")
    Pessoa findByUsuario(@Param("idUsuario") Long id);
}
