package dio.com.br.klinic.service.query;

import dio.com.br.klinic.entity.MedicoEntity;

import java.util.List;

public interface IMedicoQueryService {

    MedicoEntity findById(final long id);

    List<MedicoEntity> list();

    void verifyCpf(final String cpf);

    void verifyCpf(final long id,final String cpf);

    void verifyEmail(final String email);

    void verifyEmail(final long id,final String email);

}
