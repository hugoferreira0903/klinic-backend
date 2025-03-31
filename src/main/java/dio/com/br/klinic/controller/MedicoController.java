package dio.com.br.klinic.controller;

import dio.com.br.klinic.controller.request.SaveMedicoRequest;
import dio.com.br.klinic.controller.request.UpdateMedicoRequest;
import dio.com.br.klinic.controller.response.ListMedicoResponse;
import dio.com.br.klinic.controller.response.MedicoDetailResponse;
import dio.com.br.klinic.controller.response.SaveMedicoResponse;
import dio.com.br.klinic.controller.response.UpdateMedicoResponse;
import dio.com.br.klinic.mapper.IMedicoMapper;
import dio.com.br.klinic.service.IMedicoService;
import dio.com.br.klinic.service.query.IMedicoQueryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("medicos")
public class MedicoController {


    private final IMedicoService service;
    private final IMedicoQueryService queryService;
    private final IMedicoMapper mapper;

    public MedicoController(IMedicoService service, IMedicoQueryService queryService, IMedicoMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SaveMedicoResponse save(@RequestBody @Valid SaveMedicoRequest request){

        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateMedicoResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateMedicoRequest request){
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    ResponseEntity<String> delete(@PathVariable final long id){
        service.delete(id);
        return ResponseEntity.ok("usuario deletado com sucesso!");
    }

    @GetMapping("{id}")
    MedicoDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListMedicoResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

}
