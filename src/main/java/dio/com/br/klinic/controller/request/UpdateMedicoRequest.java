package dio.com.br.klinic.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicoRequest(

        @NotNull
        @JsonProperty("name")
        String name,
        @NotBlank(message = "O CPF não pode estar em branco")
        @JsonProperty("cpf")
        String cpf,
        @NotNull
        @JsonProperty("phone")
        String phone,
        @NotNull
        @Email
        @JsonProperty("email")
        String email,
        @NotNull
        @JsonProperty("password")
        String password

) {
}
