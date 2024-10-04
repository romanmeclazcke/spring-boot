package org.example.practico3.Controller;

import io.swagger.annotations.Api;
import org.example.practico3.Model.Socio;
import org.example.practico3.Repository.DireccionRepository;
import org.example.practico3.Repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("socios")
@Api(value = "sociosController", description = "api rest para personas")
public class SocioController {

    @Qualifier("socioRepository")
    @Autowired
    private final SocioRepository repository;

    public SocioController(@Qualifier("socioRepository") SocioRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public List<Socio> getSocios(){
        return this.repository.findAll();
    }

    @PostMapping("/")
    public Socio addSocio(@RequestBody Socio socio){
        return this.repository.save(socio);
    }

    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Integer id){
         this.repository.deleteById(id);
    }


}
