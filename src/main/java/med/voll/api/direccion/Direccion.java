package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor   //constructor sin atributos
@AllArgsConstructor   //constructor con atributos
public class Direccion {
    private String calle;
    private Integer numero;
    private String complemento;
    private String distrito;
    private String ciudad;
}
