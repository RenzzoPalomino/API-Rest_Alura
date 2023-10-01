package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;
@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor   //constructor sin atributos
@AllArgsConstructor   //constructor con atributos
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
}
