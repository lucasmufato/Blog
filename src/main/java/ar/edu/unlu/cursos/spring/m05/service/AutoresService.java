package ar.edu.unlu.cursos.spring.m05.service;

import ar.edu.unlu.cursos.spring.m05.entity.Autor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AutoresService {

    List<Autor> traerTodosOrdenadosPorMasReciente();

    List<Autor> findByNombreContaining(String nombre);

    List<Autor> findByApellidoContaining(String apellido);

    Optional<Autor> buscarId(long id);

    @Transactional
    void insertar(Autor autor);

    @Transactional
    void eliminar(long idAutor);

    @Transactional
    void actualizar(Autor autor);

}
