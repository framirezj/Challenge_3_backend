package one.oracle.ch_3_back.domain.respuesta;

import java.time.LocalDateTime;

public record DTORespuestaListado(
        Long id,
        String mensaje,
        LocalDateTime fecha,
        Long topicoId,
        Long autorId,
        String autorNombre
) {

    public DTORespuestaListado(Respuesta respuesta) {
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
