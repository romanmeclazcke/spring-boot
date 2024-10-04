package org.example.practico3.Dto;

public class PersonaSocioDto {
    private Integer id;
    private String nombre;
    private Boolean esSocio;

    public PersonaSocioDto(Boolean esSocio, Integer id, String nombre) {
        this.esSocio = esSocio;
        this.id = id;
        this.nombre = nombre;
    }
}
