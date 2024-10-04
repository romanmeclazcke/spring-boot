package org.example.practico3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Direccion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String calle;
    private String ciudad;


    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public Direccion() {

    }
}
