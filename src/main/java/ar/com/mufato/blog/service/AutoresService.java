package ar.com.mufato.blog.service;

import ar.com.mufato.blog.entity.Autor;
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
