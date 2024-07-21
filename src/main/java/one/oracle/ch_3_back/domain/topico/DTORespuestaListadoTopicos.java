package one.oracle.ch_3_back.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import one.oracle.ch_3_back.domain.respuesta.Respuesta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DTORespuestaListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        Boolean activo,
        Long autor,
        String curso,
        List<DTORespuestaListadoTopico> respuestas
) {
    public DTORespuestaListadoTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getAutor().getId(),
                topico.getCurso(),

                //para formatear la salida de los atributos de respuesta
                topico.getRespuestas()
                        .stream().map(
                                DTORespuestaListadoTopico::new
                        ).collect(Collectors.toList())
        );
    }

    public record DTORespuestaListadoTopico(

            Long id,
            String mensaje,
            LocalDateTime fecha,
            Long topicoId,
            Long autorId

    ){

        public DTORespuestaListadoTopico(Respuesta respuesta){
            this(
                    respuesta.getId(),
                    respuesta.getMensaje(),
                    respuesta.getFechaCreacion(),
                    respuesta.getTopico().getId(),
                    respuesta.getAutor().getId()
            );
        }

    }

}
