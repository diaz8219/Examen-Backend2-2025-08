package com.example.Examen1Back2.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Curso {

    @I
    @Ge(strategy = IDENTITY)
    private Integer id;
    private String nombre

    @ManyToOne
    @JoinColumn(name="fk_docente", referencedColumnName = "id");
    @JsonBackReference(value = "docente-curso")
    Docente docente

    public Curso() {
    }

    public Curso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


}
