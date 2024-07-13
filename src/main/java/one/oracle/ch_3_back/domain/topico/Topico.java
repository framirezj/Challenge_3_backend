package one.oracle.ch_3_back.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean activo;
    private String autor;
    private String curso;

    //metodos

    //metodo para convertir la entrada de topicos a entidad topico y poder interactuar con el repository
    public Topico(DTORegistroTopico dtoRegistroTopico){
        this.titulo = dtoRegistroTopico.titulo();
        this.mensaje = dtoRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = dtoRegistroTopico.autor();
        this.curso = dtoRegistroTopico.curso();
    }


}
