package com.springdatajpa.entities.entity1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    /*De esta manera se indica que el estudiante tiene una dirección asociada
    Unidireccional*/
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    private Direccion direccion;
}
