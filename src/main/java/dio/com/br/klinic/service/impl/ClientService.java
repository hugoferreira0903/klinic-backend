package dio.com.br.klinic.service.impl;

import dio.com.br.klinic.entity.ClientEntity;
import dio.com.br.klinic.exception.UniqueConstraintException;
import dio.com.br.klinic.repository.IClientRepository;
import dio.com.br.klinic.service.IClientService;
import dio.com.br.klinic.service.query.IClientQueryService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;

    public ClientService(IClientRepository repository, IClientQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }

    @Override
    public ClientEntity save(ClientEntity entity) {
        if (entity.getCpf().length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos");
        }

        if (!entity.getCpf().matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter apenas números");
        }

        if(entity.getPhone().length() != 11){
            throw new IllegalArgumentException("O telefone deve conter exatamente 11 dígitos");
        }

        if(!entity.getPhone().matches("\\d{11}")){
            throw new IllegalArgumentException("O telefone deve conter apenas números");
        }

        queryService.verifyCpf(entity.getCpf());
        queryService.verifyEmail(entity.getEmail());
        return repository.save(entity);
    }

    @Override
    public ClientEntity update(ClientEntity entity) {
        try {
            if (entity.getCpf().length() != 11) {
                throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos");
            }

            if (!entity.getCpf().matches("\\d{11}")) {
                throw new IllegalArgumentException("O CPF deve conter apenas números");
            }

            if (entity.getPhone().length() != 11) {
                throw new IllegalArgumentException("O telefone deve conter exatamente 11 dígitos");
            }

            if (!entity.getPhone().matches("\\d{11}")) {
                throw new IllegalArgumentException("O telefone deve conter apenas números");
            }

            queryService.verifyCpf(entity.getId(), entity.getCpf());
            queryService.verifyEmail(entity.getId(), entity.getEmail());

            var stored = queryService.findById(entity.getId());
            stored.setName(entity.getName());
            stored.setCpf(entity.getCpf());
            stored.setPhone(entity.getPhone());
            stored.setEmail(entity.getEmail());
            stored.setPassword(entity.getPassword());

            return repository.save(stored);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueConstraintException("O e-mail ou CPF já está cadastrado no sistema.");
        }
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
