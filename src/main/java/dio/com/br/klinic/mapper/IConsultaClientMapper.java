package dio.com.br.klinic.mapper;

import dio.com.br.klinic.controller.request.SaveConsultaClientRequest;
import dio.com.br.klinic.controller.response.ClientConsultaAppointmentResponse;
import dio.com.br.klinic.controller.response.ConsultaAppointmentMonthResponse;
import dio.com.br.klinic.controller.response.ListConsultaClientResponse;
import dio.com.br.klinic.controller.response.SaveConsultaClientResponse;
import dio.com.br.klinic.entity.ConsultaClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IConsultaClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "consulta.id", source = "consultaId")
    ConsultaClientEntity toEntity(final SaveConsultaClientRequest request);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "consultaId", source = "consulta.id")
    SaveConsultaClientResponse toSaveResponse(final ConsultaClientEntity entity);

    @Mapping(target = "consultaAppointment", expression = "java(toClientMedicoMonthResponse(entities))")
    ConsultaAppointmentMonthResponse toMonthResponse(final int year, final int month, final List<ConsultaClientEntity> entities);

    List<ClientConsultaAppointmentResponse> toClientMedicoMonthResponse(final List<ConsultaClientEntity> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "consultaId", source = "consulta.id")
    @Mapping(target = "consultaAtendimento", source = "consulta.atendimento")
    @Mapping(target = "day", expression = "java(entity.getDataConsulta().getDayOfMonth())")
    ClientConsultaAppointmentResponse toClientConsultaMonthResponse(final ConsultaClientEntity entity);

    List<ListConsultaClientResponse> toListResponse(List<ConsultaClientEntity> entities);
}

