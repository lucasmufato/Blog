package ar.edu.unlu.cursos.spring.m05.repos;

import ar.edu.unlu.cursos.spring.m05.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
