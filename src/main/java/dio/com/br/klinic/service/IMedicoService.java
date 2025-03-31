package dio.com.br.klinic.service;

import dio.com.br.klinic.entity.MedicoEntity;

public interface IMedicoService {

    MedicoEntity save(final MedicoEntity entity);

    MedicoEntity update(final MedicoEntity entity);

    void delete(final long id);

}
