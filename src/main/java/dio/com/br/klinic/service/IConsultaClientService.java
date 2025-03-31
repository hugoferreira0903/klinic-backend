package dio.com.br.klinic.service;

import dio.com.br.klinic.entity.ConsultaClientEntity;

public interface IConsultaClientService {

    ConsultaClientEntity save(final ConsultaClientEntity entity);

    void delete(final long id);

}
