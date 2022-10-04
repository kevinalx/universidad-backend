package com.springsimplespasos.universidad.universidadbackend.modelo.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona{

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY

    )
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;
    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, LocalDateTime fechaAlta, LocalDateTime fechaModificacion, Direccion direccion) {
        super(id, nombre, apellido, dni, fechaAlta, fechaModificacion, direccion);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString()
        + "Alumno{}";
    }
}
