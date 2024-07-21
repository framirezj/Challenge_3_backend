package one.oracle.ch_3_back.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopico(

        @NotNull
        String titulo,
        @NotNull
        String mensaje,

        //Long autorId,
        @NotNull
        String curso

) {
}
