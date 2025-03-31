package dio.com.br.klinic.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SaveConsultaResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("preco")
        BigDecimal preco,
        @JsonProperty("atendimento")
        String atendimento,
        @JsonProperty("medicoId")
        Long medicoId
) {
}
