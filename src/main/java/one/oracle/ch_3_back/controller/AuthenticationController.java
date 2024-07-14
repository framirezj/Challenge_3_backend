package one.oracle.ch_3_back.controller;

import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.usuario.DTOUsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

        //traer el authentication manager
        @Autowired
        private AuthenticationManager authenticationManager;

        //endpoint de login
     public ResponseEntity login(@RequestBody @Valid DTOUsuarioLogin dtoUsuarioLogin) {

        //genera el formato de token
        var authentication = new UsernamePasswordAuthenticationToken(
                dtoUsuarioLogin.username(),
                dtoUsuarioLogin.password()
        );

        //aplicar el manager
        var autorizado = authenticationManager.authenticate(authentication);

        //generar el token JWT

        //generar salida
        return ResponseEntity.ok("token de autorizado");
    }
}
