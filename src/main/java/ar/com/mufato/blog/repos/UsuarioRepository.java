package ar.com.mufato.blog.repos;

import ar.com.mufato.blog.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByNombre(String nombre);

    Usuario findUsuarioByNombreAndPassword(String nombre, String password);

    Usuario findUsuarioByMailAndPassword(String mail, String password);

}
