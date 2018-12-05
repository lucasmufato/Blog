package ar.edu.unlu.cursos.spring.m05.repos;

import ar.edu.unlu.cursos.spring.m05.entity.Autor;
import ar.edu.unlu.cursos.spring.m05.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNombreContaining(String nombre);

    List<Autor> findByApellidoContaining(String apellido);

    List<Autor> findDistinctByLibrosIn(Libro libro);

    long countByNombreContaining(String nombre);

}
