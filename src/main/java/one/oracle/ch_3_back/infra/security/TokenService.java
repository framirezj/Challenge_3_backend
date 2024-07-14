package one.oracle.ch_3_back.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import one.oracle.ch_3_back.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    //hace referencia al valor declarado en application.properties
    @Value("${JWT_SECRET}")
    private String secret;

    //METODOS APORTADOS POR LA LIBRERIA DE JWT

    //metodo que configura y genera el token, debo mandarle una entidad Usuario.
    public String generarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("CH3_BACKEND")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error al generar el  token jwt", exception);
        }
    }

    //generar la fecha de expiracion del token
    public Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-04:00"));
    }


    //*********************************************************************************************

    //metodo para verificar el token, este metodo lo proporciona el creador de la libreria en github
    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("CH3_BACKEND")
                    .build()
                    .verify(token);

            if (verifier.getSubject() != null){
                return verifier.getSubject();
            }else {
                throw new RuntimeException("error al verificar el  token");
            }

        } catch (JWTVerificationException exception){
            throw new RuntimeException("error al verificar el  token", exception);
        }
    }
}
