package dio.com.br.klinic.repository;

import dio.com.br.klinic.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
}
