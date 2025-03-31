package dio.com.br.klinic.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record ListConsultaClientResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("day")
        Integer day,
        @JsonProperty("dataConsulta")
        OffsetDateTime dataConsulta,
        @JsonProperty("clientId")
        Long clientId,
        @JsonProperty("clientName")
        String clientName,
        @JsonProperty("consultaId")
        Long consultaId,
        @JsonProperty("consultaAtendimento")
        String consultaAtendimento

) {
}
