package one.oracle.ch_3_back.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.topico.DTORegistroTopico;
import one.oracle.ch_3_back.domain.topico.DTORespuestaRegistroTopico;
import one.oracle.ch_3_back.domain.topico.Topico;
import one.oracle.ch_3_back.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public void hello(){
        System.out.println("Hello World");
    }

    //Los datos del tópico (título, mensaje, autor y curso) deben ser enviados en el cuerpo de la solicitud, en formato JSON.

    @PostMapping
    @Transactional
    public ResponseEntity<String> post(@RequestBody @Valid DTORegistroTopico dtoRegistroTopico){

        //convierte DTO de topico y guarda
        var topico = topicoRepository.save(new Topico(dtoRegistroTopico));

        //convierte la entidad a DTO de salida
        var response = new DTORespuestaRegistroTopico(topico);


        //crea el url de acceso al topico registrado



        return ResponseEntity.ok(dtoRegistroTopico.toString());
    }
}
