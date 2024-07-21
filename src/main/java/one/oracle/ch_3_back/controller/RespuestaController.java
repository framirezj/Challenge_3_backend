package one.oracle.ch_3_back.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.respuesta.DTORegistroRespuesta;
import one.oracle.ch_3_back.domain.respuesta.DTORespuestaRegistroRespuesta;
import one.oracle.ch_3_back.domain.respuesta.Respuesta;
import one.oracle.ch_3_back.domain.respuesta.RespuestaRepository;
import one.oracle.ch_3_back.domain.topico.*;
import one.oracle.ch_3_back.domain.usuario.Usuario;
import one.oracle.ch_3_back.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;


    @PostMapping("/{topicoId}")
    @Transactional
    public ResponseEntity<DTORespuestaRegistroRespuesta> registroTo(
            @PathVariable Long topicoId,
            @RequestBody DTORegistroRespuesta dtoRegistroRespuesta
    ){

            //buscar el topico al cual ingresaremos una respuesta
        Optional<Topico> topicoOptional = topicoRepository.findById(topicoId);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dtoRegistroRespuesta.autorId());


        if (topicoOptional.isPresent() && usuarioOptional.isPresent()) {

            //crear la respuesta
            var respuesta = new Respuesta(
                    dtoRegistroRespuesta,
                    topicoOptional.get(),
                    usuarioOptional.get()
            );

            //guardar la respuesta
            var respuestaSaved = respuestaRepository.save(respuesta);

            //convertir la respuesta a DTO de salida
            var respuestaDTO = new DTORespuestaRegistroRespuesta(
                    respuestaSaved);

            //pendiente url con la respuesta, todavia no tengo el endpoint

            //salida
            return ResponseEntity.ok(respuestaDTO);

        }else {
            return ResponseEntity.notFound().build();
        }
    }


}