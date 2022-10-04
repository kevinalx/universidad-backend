package com.springsimplespasos.universidad.universidadbackend.modelo.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona{

    private BigDecimal sueldo;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )

    @JoinTable(
            name = "profesor_carrera",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<Carrera> carreras;

    public Profesor(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Profesor(Integer id, String nombre, String apellido, String dni, LocalDateTime fechaAlta, LocalDateTime fechaModificacion, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, fechaAlta, fechaModificacion, direccion);
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Set<Carrera> getCarrera() {
        return carreras;
    }

    public void setCarrera(Set<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tProfesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}
