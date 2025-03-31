package dio.com.br.klinic.service.query.impl;

import dio.com.br.klinic.entity.MedicoEntity;
import dio.com.br.klinic.exception.CpfInUseException;
import dio.com.br.klinic.exception.EmailInUseException;
import dio.com.br.klinic.exception.NotFoundException;
import dio.com.br.klinic.repository.IMedicoRepository;
import dio.com.br.klinic.service.query.IMedicoQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MedicoQueryService implements IMedicoQueryService {

    private final IMedicoRepository repository;

    public MedicoQueryService(IMedicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicoEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o medico de id " + id));
    }

    @Override
    public List<MedicoEntity> list() {
        return repository.findAll();
    }

    @Override
    public void verifyCpf(String cpf) {
        if(repository.existsByCpf(cpf)){
            var message = "O cpf " + cpf + " já está em uso";
            throw new CpfInUseException(message);
        }
    }

    @Override
    public void verifyCpf(long id, String cpf) {
        var optional = repository.findByCpf(cpf);
        if(optional.isPresent() && !Objects.equals(optional.get().getCpf(), cpf)){
            var message = "O cpf " + cpf + " já está em uso";
            throw new CpfInUseException(message);
        }
    }

    @Override
    public void verifyEmail(String email) {
        if (repository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new EmailInUseException(message);
        }
    }

    @Override
    public void verifyEmail(long id, String email) {
        var optional = repository.findByEmail(email);
        if (optional.isPresent() && !Objects.equals(optional.get().getEmail(), email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new EmailInUseException(message);
        }
    }

}
