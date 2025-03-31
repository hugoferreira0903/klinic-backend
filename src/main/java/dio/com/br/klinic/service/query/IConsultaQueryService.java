package dio.com.br.klinic.service.query;

import dio.com.br.klinic.entity.ConsultaEntity;

import java.util.List;

public interface IConsultaQueryService {

    ConsultaEntity findById(final long id);

    List<ConsultaEntity> list();

}
