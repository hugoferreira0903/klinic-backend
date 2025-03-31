package dio.com.br.klinic.service.query.impl;

import dio.com.br.klinic.entity.ConsultaEntity;
import dio.com.br.klinic.exception.NotFoundException;
import dio.com.br.klinic.repository.IConsultaRepository;
import dio.com.br.klinic.service.query.IConsultaQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaQueryService implements IConsultaQueryService {

    private final IConsultaRepository repository;

    public ConsultaQueryService(IConsultaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsultaEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Consulta não encontrado")
        );
    }

    @Override
    public List<ConsultaEntity> list() {
        return repository.findAll();
    }
}
