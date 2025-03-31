package dio.com.br.klinic.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record SaveConsultaClientResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("dataConsulta")
        OffsetDateTime dataConsulta,
        @JsonProperty("clientId")
        Long clientId,
        @JsonProperty("consultaId")
        Long consultaId
) {
}
