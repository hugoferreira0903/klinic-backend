package dio.com.br.klinic.controller;


import dio.com.br.klinic.controller.request.SaveConsultaClientRequest;
import dio.com.br.klinic.controller.response.ConsultaAppointmentMonthResponse;
import dio.com.br.klinic.controller.response.ListConsultaClientResponse;
import dio.com.br.klinic.controller.response.SaveConsultaClientResponse;
import dio.com.br.klinic.mapper.IConsultaClientMapper;
import dio.com.br.klinic.mapper.IConsultaMapper;
import dio.com.br.klinic.service.IConsultaClientService;
import dio.com.br.klinic.service.query.IConsultaClientQueryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("consultas/clients")
public class ConsultaClientController {

    private final IConsultaClientService service;
    private final IConsultaClientQueryService queryService;
    private final IConsultaClientMapper mapper;

    public ConsultaClientController(IConsultaClientService service, IConsultaClientQueryService queryService, IConsultaClientMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }


    @PostMapping
    @ResponseStatus(CREATED)
    SaveConsultaClientResponse save(@RequestBody @Valid SaveConsultaClientRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @GetMapping("{year}/{month}")
    ConsultaAppointmentMonthResponse listMonth(@PathVariable final int year, @PathVariable final int month){
        var yearMonth = YearMonth.of(year, month);
        var startOfMonth = yearMonth.atDay(1).atTime(0, 0, 0, 0).atOffset(UTC);
        var endOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59, 999999999).atOffset(UTC);
        var entities = queryService.findInMonth(startOfMonth, endOfMonth);
        return mapper.toMonthResponse(year, month, entities);
    }

    @GetMapping
    List<ListConsultaClientResponse> toList(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("consulta deletado com sucesso!");
    }

}
