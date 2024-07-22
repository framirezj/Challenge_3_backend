package one.oracle.ch_3_back.domain.topico;

import jakarta.persistence.*;
import lombok.*;
import one.oracle.ch_3_back.domain.respuesta.Respuesta;
import one.oracle.ch_3_back.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
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
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private Boolean activo;
    private String curso;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas = new ArrayList<>();

    //metodos

    //metodo para convertir la entrada de topicos a entidad topico y poder interactuar con el repository
    public Topico(DTORegistroTopico dtoRegistroTopico){
        this.titulo = dtoRegistroTopico.titulo();
        this.mensaje = dtoRegistroTopico.mensaje();
        //this.fechaCreacion = LocalDateTime.now();
        this.activo = true;
        //this.autor = dtoRegistroTopico.autorId();
        this.curso = dtoRegistroTopico.curso();
    }


}
