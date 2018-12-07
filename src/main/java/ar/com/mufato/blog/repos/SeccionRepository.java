package ar.com.mufato.blog.repos;

import ar.com.mufato.blog.entity.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Long> {
}
