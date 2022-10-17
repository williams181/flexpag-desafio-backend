package com.flexpag.paymentscheduler.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query(value = "SELECT imo FROM Agendamento imo WHERE imo.idUsuarioFK.idUsuario = :usuario_id")
    Agendamento retornaAgendamentoPorUsuario(@Param("usuario_id") Long usuario_id);
    
}
