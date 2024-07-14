package one.oracle.ch_3_back.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOUsuarioLogin(

        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
