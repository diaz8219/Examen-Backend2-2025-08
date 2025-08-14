package com.example.APIExamenBack.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "especialidad", nullable = false, unique = true, length = 20)
    private  String especialidad;

    public Docente() {
    }

    public Docente(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}