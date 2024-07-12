package one.oracle.ch_3_back.controller;

import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.topico.DTORegistroTopico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping
    public void hello(){
        System.out.println("Hello World");
    }

    //Los datos del tópico (título, mensaje, autor y curso) deben ser enviados en el cuerpo de la solicitud, en formato JSON.

    @PostMapping
    public ResponseEntity<String> post(@RequestBody @Valid DTORegistroTopico dtoRegistroTopico){
        return ResponseEntity.ok("Hello World");
    }
}
