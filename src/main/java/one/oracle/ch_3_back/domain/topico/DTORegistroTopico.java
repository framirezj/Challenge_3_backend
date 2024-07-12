package one.oracle.ch_3_back.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DTORegistroTopico(
        //Los datos del tópico (título, mensaje, autor y curso)

        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        String autor,
        @NotNull
        String curso
) {
}
