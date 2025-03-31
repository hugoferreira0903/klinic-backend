package dio.com.br.klinic.mapper;

import dio.com.br.klinic.controller.request.SaveClientRequest;
import dio.com.br.klinic.controller.request.UpdateClientRequest;
import dio.com.br.klinic.controller.response.ClientDetailResponse;
import dio.com.br.klinic.controller.response.ListClientResponse;
import dio.com.br.klinic.controller.response.SaveClientResponse;
import dio.com.br.klinic.controller.response.UpdateClientResponse;
import dio.com.br.klinic.entity.ClientEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    ClientEntity toEntity(final long id, final @Valid UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);


}
