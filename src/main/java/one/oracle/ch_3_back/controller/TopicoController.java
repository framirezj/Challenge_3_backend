package one.oracle.ch_3_back.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    /*
    @GetMapping
    public void hello(){
        System.out.println("Hello World");
    }
    */


    //Los datos del tópico (título, mensaje, autor y curso)
    //deben ser enviados en el cuerpo de la solicitud, en formato JSON.

    @PostMapping
    @Transactional
    public ResponseEntity<DTORespuestaRegistroTopico> registroTopico(
            @RequestBody @Valid DTORegistroTopico dtoRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder){

        //convierte DTO de topico y guarda
        var topico = topicoRepository
                .save(new Topico(dtoRegistroTopico));


        //convierte la entidad a DTO de salida
        var response = new DTORespuestaRegistroTopico(topico);


        //crea el url de acceso al topico registrado
        URI url = uriComponentsBuilder
                .path("/topicos/{id}")
                .buildAndExpand(
                        topico.getId()).toUri();

        return ResponseEntity
                .created(url)
                .body(response);
    }

    //Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso)
    // deben ser devueltos en el cuerpo de la respuesta, en formato JSON.

    @GetMapping
    public ResponseEntity<Page<DTORespuestaListadoTopicos>> getAllTopicos(
            @PageableDefault(size = 10) Pageable pageable
    ){

        //obtener los topicos desde la base de datos, paginarlos y convertilos a DTO de salida.
        return ResponseEntity.ok(topicoRepository.findAll(pageable)
                .map(DTORespuestaListadoTopicos::new));

    }
}
