package org.example.practico3.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int anios;

    @Column
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion domicilio;


    @ManyToMany(mappedBy = "pacientes")
    private List<Turno> turnos;


    public Persona(int anios, int id, String nombre) {
        this.anios = anios;
        this.id = id;
        this.nombre = nombre;
    }

    public Persona() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + anios +
                '}';
    }

}