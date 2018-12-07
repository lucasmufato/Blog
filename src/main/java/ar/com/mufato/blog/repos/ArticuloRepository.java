package ar.com.mufato.blog.repos;

import ar.com.mufato.blog.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
