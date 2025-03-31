package dio.com.br.klinic.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record SaveConsultaClientRequest(

        @NotNull
        @JsonProperty("dataConsulta")
        OffsetDateTime dataConsulta,
        @NotNull
        @JsonProperty("clientId")
        Long clientId,
        @NotNull
        @JsonProperty("consultaId")
        Long consultaId

) {
}
