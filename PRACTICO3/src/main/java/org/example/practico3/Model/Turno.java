package org.example.practico3.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Turno {

    @Id
    private Integer id;

    @Column
    private Date fecha;

    @ManyToMany()
    private List<Persona> pacientes;

    public Turno(Integer id, Date fecha){
        this.id=id;
        this.fecha=fecha;
        this.pacientes=new ArrayList<>();
    }

    public void addPaciente(Persona p){
        this.pacientes.add(p);
    }

}
