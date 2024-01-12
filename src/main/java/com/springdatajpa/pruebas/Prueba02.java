package com.springdatajpa.pruebas;

import com.springdatajpa.entities.entity2.Autor;
import com.springdatajpa.entities.entity2.Libro;
import com.springdatajpa.repositories.repository2.AutorRepository;
import com.springdatajpa.repositories.repository2.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba02 implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void run(String... args) throws Exception {
        //Creamos el autor
        Autor autor = new Autor();
        autor.setNombre("Sr. Borges");

        //Creamos libro y se lo agregamos al autor
        Libro libro = new Libro();
        libro.setTitulo("Hola");

        Libro libro2 = new Libro();
        libro.setTitulo("Chao");

        autor.getLibros().add(libro);
        autor.getLibros().add(libro2);

        //Se guarda el autor y automaticamente los libros correspondientes ya que se utiliza CascadeType.All
        autorRepository.save(autor);
    }
}
