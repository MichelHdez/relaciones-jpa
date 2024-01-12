package com.springdatajpa.repositories.repository2;

import com.springdatajpa.entities.entity2.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
