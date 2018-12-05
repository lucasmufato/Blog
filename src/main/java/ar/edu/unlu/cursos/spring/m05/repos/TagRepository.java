package ar.edu.unlu.cursos.spring.m05.repos;

import ar.edu.unlu.cursos.spring.m05.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
