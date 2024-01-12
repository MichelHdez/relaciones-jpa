package com.springdatajpa.pruebas;

import com.springdatajpa.entities.entity1.Direccion;
import com.springdatajpa.entities.entity1.Estudiante;
import com.springdatajpa.repositories.repository1.DireccionRepository;
import com.springdatajpa.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba01 implements CommandLineRunner {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion();
        direccion.setCalle("5 Principal");
        direccion.setCiudad("Xalapa");
        direccion.setCodigoPostal("91100");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Jose");
        estudiante.setDireccion(direccion);

        estudianteRepository.save(estudiante);

        /*estudiante.setNombre("Ana");
        estudiante.setDireccion(direccion);
        estudianteRepository.save(estudiante);*/

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        for(Estudiante e : estudiantes){
            System.out.println("Estudiante : " + e.getNombre());
        }
    }
}
