package dio.com.br.klinic.service.query;

import dio.com.br.klinic.entity.ConsultaClientEntity;

import java.time.OffsetDateTime;
import java.util.List;

public interface IConsultaClientQueryService {

    ConsultaClientEntity findById(final long id);

    List<ConsultaClientEntity> findInMonth(final OffsetDateTime startOfMonth, final OffsetDateTime endOfMonth);

    List<ConsultaClientEntity> list();

}
