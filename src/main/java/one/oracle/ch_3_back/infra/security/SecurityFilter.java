package one.oracle.ch_3_back.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import one.oracle.ch_3_back.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //en la configuraciones de spring configuramos este filtro para que atrape las request
        //obtener el token
        //desde el header obtengo lo que venga dentro de Authorization, que tendria que ser un Bearer (token)
        var token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            //servicio que verificara el token, si existe alguna exception se manejara aqui
            String subject = tokenService.getSubject(token);

            if (subject != null) {
                //como el subject no es nulo lo buscaremos en la base de datos
                UserDetails usuario = usuarioRepository.findByUser(subject);

                //con esta linea forzamos el inicio de sesion, diciendole a spring que ya inicio en login
                var authentication = new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        usuario.getAuthorities());

                //le pasamos a la seguridad de spring que esta autenticado
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }


        //paso al proximo filtro
        filterChain.doFilter(request, response);

    }
}
