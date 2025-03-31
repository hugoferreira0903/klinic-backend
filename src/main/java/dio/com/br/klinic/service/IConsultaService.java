package dio.com.br.klinic.service;

import dio.com.br.klinic.entity.ConsultaEntity;

public interface IConsultaService {

    ConsultaEntity save(final ConsultaEntity entity);

    void delete(final long id);

}
