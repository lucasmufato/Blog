package ar.com.mufato.blog.repos;

import ar.com.mufato.blog.entity.Autor;
import ar.com.mufato.blog.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNombreContaining(String nombre);

    List<Autor> findByApellidoContaining(String apellido);

    List<Autor> findDistinctByLibrosIn(Libro libro);

    long countByNombreContaining(String nombre);

}
