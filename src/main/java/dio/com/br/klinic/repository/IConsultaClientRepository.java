package dio.com.br.klinic.repository;

import dio.com.br.klinic.entity.ConsultaClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface IConsultaClientRepository extends JpaRepository<ConsultaClientEntity, Long> {

    List<ConsultaClientEntity> findByDataConsultaBetween(final OffsetDateTime startAt, final OffsetDateTime endAt);

}
