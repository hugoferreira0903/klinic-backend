package dio.com.br.klinic.service.query;

import dio.com.br.klinic.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface IClientQueryService {

    ClientEntity findById(final long id);

    List<ClientEntity> list();

    void verifyCpf(final String cpf);

    void verifyCpf(final long id,final String cpf);

    void verifyEmail(final String email);

    void verifyEmail(final long id,final String email);

    Optional<ClientEntity> findByEmail(String email);

}
