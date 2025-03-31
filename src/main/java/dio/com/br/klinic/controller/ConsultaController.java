package dio.com.br.klinic.controller;

import dio.com.br.klinic.controller.request.SaveConsultaRequest;
import dio.com.br.klinic.controller.response.ListConsultaResponse;
import dio.com.br.klinic.controller.response.SaveConsultaResponse;
import dio.com.br.klinic.mapper.IConsultaMapper;
import dio.com.br.klinic.service.IConsultaService;
import dio.com.br.klinic.service.query.IConsultaQueryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    private final IConsultaService service;
    private final IConsultaQueryService queryService;
    private final IConsultaMapper mapper;

    public ConsultaController(IConsultaService service, IConsultaQueryService queryService, IConsultaMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    SaveConsultaResponse save(@RequestBody @Valid SaveConsultaRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @GetMapping
    List<ListConsultaResponse> toList(){
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
