package com.springdatajpa.repositories.repository1;

import com.springdatajpa.entities.entity1.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
