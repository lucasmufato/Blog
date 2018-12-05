package ar.edu.unlu.cursos.spring.m05.service;

import ar.edu.unlu.cursos.spring.m05.entity.Autor;
import ar.edu.unlu.cursos.spring.m05.entity.Libro;
import ar.edu.unlu.cursos.spring.m05.repos.LibrosRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class LibrosServiceImpl implements LibrosService {

    private final LibrosRepository librosRepository;

    @Inject
    public LibrosServiceImpl(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return librosRepository.findByTituloContaining(titulo);
    }

    @Override
    public Optional<Libro> buscarPorISBN(String isbn) {
        return librosRepository.findByIsbn(isbn);
    }

    @Override
    public List<Libro> buscarPorAutor(Autor autor) {
        return librosRepository.findByAutor(autor);
    }

    @Override
    public Optional<Libro> buscarId(long id) {
        return librosRepository.findById(id);
    }

    @Override
    public List<Libro> traerTodosOrdenadosPorMasReciente() {
        return librosRepository.findAll(Sort.by("modifiedOn").descending());
    }

    @Transactional
    @Override
    public void insertar(Libro l) {
        librosRepository.save(l);
    }

    @Transactional
    @Override
    public void eliminar(long id) {
        librosRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void actualizar(Libro l) {
        librosRepository.save(l);
    }
}
