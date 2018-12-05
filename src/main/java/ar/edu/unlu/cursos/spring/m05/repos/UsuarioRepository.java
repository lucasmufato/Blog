package ar.edu.unlu.cursos.spring.m05.repos;

import ar.edu.unlu.cursos.spring.m05.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
