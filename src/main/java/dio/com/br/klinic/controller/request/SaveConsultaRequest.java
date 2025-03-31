package dio.com.br.klinic.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record SaveConsultaRequest(

        @NotNull
        @JsonProperty("preco")
        BigDecimal preco,
        @NotNull
        @JsonProperty("atendimento")
        String atendimento,
        @NotNull
        @JsonProperty("medicoId")
        Long medicoId

) {
}
