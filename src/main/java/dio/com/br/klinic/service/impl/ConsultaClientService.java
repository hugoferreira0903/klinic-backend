package dio.com.br.klinic.service.impl;

import dio.com.br.klinic.entity.ConsultaClientEntity;
import dio.com.br.klinic.repository.IConsultaClientRepository;
import dio.com.br.klinic.service.IConsultaClientService;
import dio.com.br.klinic.service.query.IConsultaClientQueryService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaClientService implements IConsultaClientService {

    private final IConsultaClientRepository repository;
    private final IConsultaClientQueryService queryService;

    public ConsultaClientService(IConsultaClientRepository repository, IConsultaClientQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }

    @Override
    public ConsultaClientEntity save(ConsultaClientEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
