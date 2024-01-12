package com.springdatajpa.repositories.repository1;

import com.springdatajpa.entities.entity1.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
