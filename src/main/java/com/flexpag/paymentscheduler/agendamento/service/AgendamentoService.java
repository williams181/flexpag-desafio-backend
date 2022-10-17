package com.flexpag.paymentscheduler.agendamento.service;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flexpag.paymentscheduler.pagamento.repository.PagamentoRepository;
import com.flexpag.paymentscheduler.agendamento.builder.AgendamentoBuilder;
import com.flexpag.paymentscheduler.agendamento.model.EnumStatusAgendamento;
import com.flexpag.paymentscheduler.agendamento.model.Agendamento;
import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;
import com.flexpag.paymentscheduler.agendamento.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.usuario.repository.UsuarioRepository;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoBuilder builder;

    @Autowired
    AgendamentoRepository repository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private List<Agendamento> listAgendamento;

    public AgendamentoService(List<Agendamento> listAgendamento) {
        super();
        this.listAgendamento = listAgendamento;
        this.repository = repository;
        this.pagamentoRepository = pagamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Agendamento> listarAgendamentoTodes() {
        return repository.findAll();
    }

    public List<AgendamentoDto> listarAgendamento() {
        List<AgendamentoDto> listaAgendamentoDtos = new ArrayList<>();

        repository.findAll().forEach(Agendamento -> {
            listaAgendamentoDtos.add(builder.builderDto(Agendamento));
        });

        return listaAgendamentoDtos;
    }

    @Transactional
    public AgendamentoDto salvar(AgendamentoDto agendamentoDto) {

        var usuario = usuarioRepository.findById(agendamentoDto.getIdUsuarioFK()).orElseThrow();
        var pagamento = pagamentoRepository.findById(agendamentoDto.getIdPagamentoFK()).orElseThrow();
       

        var agendamento = builder.builderModel(agendamentoDto, pagamento, usuario,
                EnumStatusAgendamento.valueOf(agendamentoDto.getStatusAgendamento()));
        var agendamentoSalvo = builder.builderDto(repository.save(agendamento));
        return agendamentoSalvo;
    }

    public AgendamentoDto encontrarAgendamento(Long idAgendamento) {
        var agendamento = repository.findById(idAgendamento).orElseThrow();
        return builder.builderDto(agendamento);
    }

    @Transactional
    public AgendamentoDto alterar(Long idAgendamento, AgendamentoDto agendamentoDto) {
        var usuario = usuarioRepository.findById(agendamentoDto.getIdUsuarioFK()).orElseThrow();
        var pagamento = pagamentoRepository.findById(agendamentoDto.getIdPagamentoFK()).orElseThrow();
        
        agendamentoDto.setIdAgendamento(idAgendamento);
        
        var agendamento = builder.builderModel(agendamentoDto, pagamento, usuario,
                EnumStatusAgendamento.valueOf(agendamentoDto.getStatusAgendamento()));
        return builder.builderDto(repository.save(agendamento));
    }

    @Transactional
    public void removerAgendamento(Long id) {
        repository.deleteById(id);
    }

    public List<AgendamentoDto> retornaAgendamentoPorUsuarioEspecifico(Long id) {
        var agendamento = repository.retornaAgendamentoPorUsuario(id);
        var agendamentoDto = builder.builderDto(agendamento);

        List<AgendamentoDto> listaDeAgendamento = new ArrayList<>();
        listaDeAgendamento.add(agendamentoDto);
        return listaDeAgendamento;
    }


  
}
