package dio.com.br.klinic.mapper;

import dio.com.br.klinic.controller.request.SaveMedicoRequest;
import dio.com.br.klinic.controller.request.UpdateMedicoRequest;
import dio.com.br.klinic.controller.response.ListMedicoResponse;
import dio.com.br.klinic.controller.response.MedicoDetailResponse;
import dio.com.br.klinic.controller.response.SaveMedicoResponse;
import dio.com.br.klinic.controller.response.UpdateMedicoResponse;
import dio.com.br.klinic.entity.MedicoEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IMedicoMapper {

    MedicoEntity toEntity(final SaveMedicoRequest request);

    SaveMedicoResponse toSaveResponse(final MedicoEntity entity);

    MedicoEntity toEntity(final long id, final @Valid UpdateMedicoRequest request);

    UpdateMedicoResponse toUpdateResponse(final MedicoEntity entity);

    MedicoDetailResponse toDetailResponse(final MedicoEntity entity);

    List<ListMedicoResponse> toListResponse(final List<MedicoEntity> entities);

}
