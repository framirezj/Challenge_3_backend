package one.oracle.ch_3_back.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //metodo para la autenticacion de UserDetailsService
    UserDetails findByUser(String username);

}
