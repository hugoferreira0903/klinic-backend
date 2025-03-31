package dio.com.br.klinic.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ListMedicoResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("cpf")
        String cpf,
        @JsonProperty("phone")
        String phone,
        @JsonProperty("email")
        String email,
        @JsonProperty("password")
        String password
) {
}
