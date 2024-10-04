package org.example.practico3.Controller;

import io.swagger.annotations.Api;
import org.example.practico3.Model.Persona;
import org.example.practico3.Model.Socio;
import org.example.practico3.Model.Turno;
import org.example.practico3.Repository.SocioRepository;
import org.example.practico3.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turno")
@Api(value = "turnoController", description = "api rest para turnos")
public class TurnoController {


    @Qualifier("turnoRepository")
    @Autowired
    private final TurnoRepository repository;
    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoController(@Qualifier("turnoRepository") TurnoRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public List<Turno> getTurnos(){
        return this.repository.findAll();
    }

    @PostMapping("/")
    public Turno addTurno(@RequestBody Turno turno){
        return this.repository.save(turno);
    }

    @DeleteMapping("/{id}")
    public void deleteTurno(@PathVariable Integer id){
        this.repository.deleteById(id);
    }

    public void addPersonaToTurno(Persona p, Turno t){
        t.addPaciente(p);
        this.repository.save(t);
    }


    @GetMapping("personas-asiganadas/{turnoId}")
    public List<Persona> getPersonasAsiganasATurno(@PathVariable Integer turnoId){
        return turnoRepository.getPersonasAsignadasATurno(turnoId);
    }
}
