package dio.com.br.klinic.controller;


import dio.com.br.klinic.controller.request.LoginRequest;
import dio.com.br.klinic.controller.request.SaveClientRequest;
import dio.com.br.klinic.controller.request.UpdateClientRequest;
import dio.com.br.klinic.controller.response.ClientDetailResponse;
import dio.com.br.klinic.controller.response.ListClientResponse;
import dio.com.br.klinic.controller.response.SaveClientResponse;
import dio.com.br.klinic.controller.response.UpdateClientResponse;
import dio.com.br.klinic.mapper.IClientMapper;
import dio.com.br.klinic.service.IClientService;
import dio.com.br.klinic.service.query.IClientQueryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final IClientService service;
    private final IClientQueryService queryService;
    private final IClientMapper mapper;

    public ClientController(IClientService service, IClientQueryService queryService, IClientMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request){

        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateClientResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateClientRequest request){
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
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }


    @GetMapping
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        var client = queryService.findByEmail(request.email());

        if (client.isEmpty() || !client.get().getPassword().equals(request.password())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou Password inválidos");
        }

        return ResponseEntity.ok("Login bem-sucedido");
    }

}
