package one.oracle.ch_3_back.domain.topico;

import java.time.LocalDateTime;

public record DTORespuestaRegistroTopico(

         Long id,
         String titulo,
         String mensaje,
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
