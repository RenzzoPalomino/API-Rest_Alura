package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedicos(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico ){
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2,sort = "nombre") Pageable paginacion){  //@PageableDefault reescribe los valores por
                                                                                                                    // defecto de paginacion que Spring plantea
       //http://localhost:8080/medicos?size=1
        // http://localhost:8080/medicos?size=1&page=1

       //para odernar en fx a un parametro:
        //http://localhost:8080/medicos?size=10&page=0&sort=nombre
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }



}
