package dio.com.br.klinic.service.impl;

import dio.com.br.klinic.entity.ConsultaEntity;
import dio.com.br.klinic.repository.IConsultaRepository;
import dio.com.br.klinic.service.IConsultaService;
import dio.com.br.klinic.service.query.IConsultaQueryService;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultaService implements IConsultaService {

    private final IConsultaRepository repository;
    private final IConsultaQueryService queryService;

    public ConsultaService(IConsultaRepository repository, IConsultaQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }


    @Override
    public ConsultaEntity save(ConsultaEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }

}
