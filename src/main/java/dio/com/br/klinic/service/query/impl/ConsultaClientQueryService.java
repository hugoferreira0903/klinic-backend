package dio.com.br.klinic.service.query.impl;

import dio.com.br.klinic.entity.ConsultaClientEntity;
import dio.com.br.klinic.exception.NotFoundException;
import dio.com.br.klinic.repository.IConsultaClientRepository;
import dio.com.br.klinic.service.query.IConsultaClientQueryService;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class ConsultaClientQueryService implements IConsultaClientQueryService {

    private final IConsultaClientRepository repository;

    public ConsultaClientQueryService(IConsultaClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public ConsultaClientEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado")
        );
    }

    @Override
    public List<ConsultaClientEntity> findInMonth(OffsetDateTime startOfMonth, OffsetDateTime endOfMonth) {
        return repository.findByDataConsultaBetween(startOfMonth, endOfMonth);
    }

    @Override
    public List<ConsultaClientEntity> list() {
        return repository.findAll();
    }
}
