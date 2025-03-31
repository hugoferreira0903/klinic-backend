package dio.com.br.klinic.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ConsultaAppointmentMonthResponse(

        @JsonProperty("year")
        int year,
        @JsonProperty("month")
        int month,
        List<ClientConsultaAppointmentResponse> consultaAppointment

) {
}
