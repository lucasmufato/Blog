package ar.com.mufato.blog.service;

import ar.com.mufato.blog.entity.Autor;
import ar.com.mufato.blog.entity.Libro;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LibrosService {

    List<Libro> buscarPorTitulo(String titulo);

    Optional<Libro> buscarPorISBN(String isbn);

    List<Libro> buscarPorAutor(Autor autor);

    Optional<Libro> buscarId(long id);

    List<Libro> traerTodosOrdenadosPorMasReciente();

    @Transactional
    void insertar(Libro l);

    @Transactional
    void eliminar(long id);

    @Transactional
    void actualizar(Libro l);

}
