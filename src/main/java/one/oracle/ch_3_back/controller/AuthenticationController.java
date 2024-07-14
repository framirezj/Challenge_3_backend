package one.oracle.ch_3_back.controller;

import jakarta.validation.Valid;
import one.oracle.ch_3_back.domain.usuario.DTOUsuarioLogin;
import one.oracle.ch_3_back.domain.usuario.Usuario;
import one.oracle.ch_3_back.infra.security.DTOTokenJWT;
import one.oracle.ch_3_back.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

        //traer el authentication manager
        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenService tokenService;

        //endpoint de login
     @PostMapping
     public ResponseEntity login(@RequestBody @Valid DTOUsuarioLogin dtoUsuarioLogin) {

        //genera el formato de token
        var authentication = new UsernamePasswordAuthenticationToken(
                dtoUsuarioLogin.username(),
                dtoUsuarioLogin.password()
        );

        //aplicar el manager
        var autorizado = authenticationManager.authenticate(authentication);

        //generar el token JWT mediante el servicio definido
         //generamos el JWT, para eso le pasamos el autorizado, que contiene principal, que es el objeto usuario.
         var jwtToken = tokenService.generarToken((Usuario) autorizado.getPrincipal());

        //generar salida
        return ResponseEntity.ok(new DTOTokenJWT(jwtToken));
    }
}
