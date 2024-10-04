package org.example.practico3.Controller;
import io.swagger.annotations.Api;
import org.example.practico3.Dto.PersonaSocioDto;
import org.example.practico3.Model.Persona;
import org.example.practico3.Repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("personas")
@Api(value = "personasController", description = "api rest para personas")
public class PersonaController {

    @Qualifier("personasRepository")
    @Autowired
    private final PersonasRepository repository;


    public PersonaController(@Qualifier("personasRepository") PersonasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Persona> getPersonas(){
        return this.repository.findAll();
    }


    @PostMapping("/new")
    public Persona newPerson(@RequestBody Persona p) {
        return repository.save(p);
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("turno/{idTurno}")
    public List<Persona> getPersonasByTurno(@PathVariable Integer idTurno) {
        return this.repository.getPersonasByTurno(idTurno);
    }

    @GetMapping("turno/{idTurno}/socios")
    public List<PersonaSocioDto> getPersonasByTurnoYMarcarSocios(@PathVariable Integer idTurno) {
        List<Persona> personas=  this.repository.getPersonasByTurno(idTurno);
        List<Persona> socios = this.repository.getSocios();

        List<PersonaSocioDto> result= new ArrayList<>();

        for (Persona persona :personas){
            if(socios.contains(persona)){
                result.add(new PersonaSocioDto(true, persona.getId(), persona.getNombre()));
            }else{
                result.add(new PersonaSocioDto(false, persona.getId(), persona.getNombre()));
            }
        }
        return result;
    }


    @GetMapping("turno/{idCiudad}")
    public List<Persona> getPersonasByCiudad(@PathVariable Integer idCiudad) {
        return this.repository.getPersonasByCiudad(idCiudad);
    }


}
