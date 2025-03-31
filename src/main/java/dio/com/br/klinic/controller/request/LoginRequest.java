package dio.com.br.klinic.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank
        @Email
        String email,
        @NotBlank
        String password

) {
}
