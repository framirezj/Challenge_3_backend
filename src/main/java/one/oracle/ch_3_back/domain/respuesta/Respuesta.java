package one.oracle.ch_3_back.domain.respuesta;

import jakarta.persistence.*;
import lombok.*;
import one.oracle.ch_3_back.domain.topico.Topico;
import one.oracle.ch_3_back.domain.usuario.Usuario;

import java.time.LocalDateTime;

//tengo un error aqui, porque la tabla tenia que nombrar como respuestas, me falto una S
@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucion;

    public Respuesta(
            DTORegistroRespuesta dtoRegistroRespuesta,
            Topico topico,
            Usuario autor) {

        this.mensaje = dtoRegistroRespuesta.mensaje();
        //this.fechaCreacion = LocalDateTime.now();
        this.topico = topico;
        this.autor = autor;
        this.solucion = false;
    }
}
