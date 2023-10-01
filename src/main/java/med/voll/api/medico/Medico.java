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

    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre()!=null){
            this.nombre = datosActualizarMedico.nombre();
        }

        if(datosActualizarMedico.documento()!=null){
            this.documento = datosActualizarMedico.documento();

        }
        if(datosActualizarMedico.direccion()!=null){
            this.direccion = direccion.actualizaDatos(datosActualizarMedico.direccion());

        }
    }
}
