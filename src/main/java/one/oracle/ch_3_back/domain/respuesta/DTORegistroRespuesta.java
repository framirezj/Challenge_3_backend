package one.oracle.ch_3_back.domain.respuesta;

import lombok.NonNull;
import one.oracle.ch_3_back.domain.topico.Topico;

import java.time.LocalDateTime;

public record DTORegistroRespuesta(

        @NonNull
        String mensaje,
        @NonNull
        Long autorId



) {
}
