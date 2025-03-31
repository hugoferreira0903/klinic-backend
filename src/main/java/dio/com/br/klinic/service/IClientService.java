package dio.com.br.klinic.service;

import dio.com.br.klinic.entity.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);

}
