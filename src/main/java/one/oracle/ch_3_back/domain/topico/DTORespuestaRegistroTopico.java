package one.oracle.ch_3_back.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DTORespuestaRegistroTopico(

         Long id,
         String titulo,
         String mensaje,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
         LocalDateTime fechaCreacion,
         String autor,
         String curso
)
{
    //constructor para convertir la respuesta de registro de topico
    public DTORespuestaRegistroTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
