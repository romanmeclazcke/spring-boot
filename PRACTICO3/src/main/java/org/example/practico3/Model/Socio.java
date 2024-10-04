package org.example.practico3.Model;

import jakarta.persistence.*;

@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Genera automáticamente un ID único
    private Integer id;

    @OneToOne
    @JoinColumn(name = "persona_id")  // Establece la columna para la relación con Persona
    private Persona p;

    @Column
    private String tipo;

    // Constructor con argumentos
    public Socio(Persona p, String tipo) {
        this.p = p;
        this.tipo = tipo;
    }

    // Constructor vacío
    public Socio() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


