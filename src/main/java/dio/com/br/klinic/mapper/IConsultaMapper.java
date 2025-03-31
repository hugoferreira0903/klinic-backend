package dio.com.br.klinic.mapper;

import dio.com.br.klinic.controller.request.SaveConsultaRequest;
import dio.com.br.klinic.controller.response.ListConsultaResponse;
import dio.com.br.klinic.controller.response.SaveConsultaResponse;
import dio.com.br.klinic.entity.ConsultaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IConsultaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medico.id", source = "medicoId")
    ConsultaEntity toEntity(final SaveConsultaRequest request);

    @Mapping(target = "medicoId", source = "medico.id")
    SaveConsultaResponse toSaveResponse(final ConsultaEntity entity);

    List<ListConsultaResponse> toListResponse(List<ConsultaEntity> entities);

}
