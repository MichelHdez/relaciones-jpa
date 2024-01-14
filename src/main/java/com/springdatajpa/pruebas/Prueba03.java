package com.springdatajpa.pruebas;

import com.springdatajpa.entities.entity3.Editor;
import com.springdatajpa.entities.entity3.Revista;
import com.springdatajpa.repositories.repository3.EditorRepository;
import com.springdatajpa.repositories.repository3.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Prueba03 implements CommandLineRunner {

    @Autowired
    private RevistaRepository revistaRepository;

    @Autowired
    private EditorRepository editorRepository;

    @Override
    public void run(String... args) throws Exception {
        //Creamos el editor
        Editor editor = new Editor();
        editor.setNombre("Mexicana");

        Editor editor2 = new Editor();
        editor2.setNombre("Panini");

        //Crear libros y agregarlas al editor
        Revista revista = new Revista();
        revista.setNombre("QUO");
        revista.setEditor(editor);

        Revista revista2 = new Revista();
        revista2.setNombre("Muy Interesante");
        revista2.setEditor(editor2);

        editor.getRevistas().add(revista);
        editor2.getRevistas().add(revista2);

        //Se guardan los editores
        editorRepository.save(editor);
        editorRepository.save(editor2);

        //Leer el editor recien guardado y sus revistas
        Optional<Editor> editorGuardado = editorRepository.findById(editor.getId());
        if (editorGuardado.isPresent()) {
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido : " + editorObtenido.getNombre());

            //Actualizar el nombre del editor
            editorObtenido.setNombre("Editorial ABC");
            editorRepository.save(editorObtenido);
            System.out.println("Editor actualizado : " + editorObtenido.getNombre());

            //Leer el editor recien guardado y sus revistas
            Optional<Revista> revistaOptional = revistaRepository.findById(revista.getId());
            if (revistaOptional.isPresent()) {
                Revista revistaEliminar = revistaOptional.get();
                revistaRepository.delete(revistaEliminar);
                System.out.println("Revista eliminada: " + revistaEliminar.getNombre());
            } else {
                System.out.println("Revista no encontrada");
            }
        } else {
            System.out.println("Editor no encontrado");
        }
    }
}

