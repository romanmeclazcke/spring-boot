package org.example.practico3.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import org.example.practico3.Model.Direccion;
import org.example.practico3.Model.Persona;
import org.example.practico3.Repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("direccion")
@Api(value = "direccionController", description = "api rest para personas")
public class DireccionController {

    @Qualifier("direccionRepository")
    @Autowired //inyeccion de dependencias
    private final DireccionRepository repository;

    public DireccionController(@Qualifier("direccionRepository") DireccionRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/")
    public List<Direccion> getDirecciones(){
        return this.repository.findAll();
    }

    @PostMapping("/new")
    public Direccion newDireccion(@RequestBody Direccion d) {
        return repository.save(d);
    }
    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
