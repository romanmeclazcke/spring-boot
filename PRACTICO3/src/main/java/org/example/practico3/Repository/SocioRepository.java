package org.example.practico3.Repository;

import org.example.practico3.Model.Direccion;
import org.example.practico3.Model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Integer> {
}
