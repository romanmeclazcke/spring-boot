package org.example.practico3.Repository;

import org.example.practico3.Model.Direccion;
import org.example.practico3.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository  extends JpaRepository<Direccion, Integer> {
}
