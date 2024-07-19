package one.oracle.ch_3_back.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DTORespuestaTopicoPorId(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        Boolean activo,
        Long autor,
        String curso
) {
    public DTORespuestaTopicoPorId(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getAutor().getId(),
                topico.getCurso()
        );
    }
}
