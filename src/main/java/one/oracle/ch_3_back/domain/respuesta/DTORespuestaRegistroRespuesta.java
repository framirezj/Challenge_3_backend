package one.oracle.ch_3_back.domain.respuesta;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DTORespuestaRegistroRespuesta(
        Long id,
        String mensaje,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fecha,
        Long topicoId,
        Long autorId,
        String autorNombre

) {

    public DTORespuestaRegistroRespuesta(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId(),
                respuesta.getAutor().getUsername()
        );
    }

}
