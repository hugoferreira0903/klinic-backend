package dio.com.br.klinic.repository;

import dio.com.br.klinic.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {


    boolean existsByCpf(String cpf);

    boolean existsByEmail(final String email);

    Optional<ClientEntity> findByEmail(final String email);

    Optional<ClientEntity> findByCpf(final String cpf);

}
