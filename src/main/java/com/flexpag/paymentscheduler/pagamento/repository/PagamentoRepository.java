package com.flexpag.paymentscheduler.pagamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flexpag.paymentscheduler.pagamento.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findAllByIdPessoa(Long idPessoa);

}