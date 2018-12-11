package ar.com.mufato.blog.service;

import ar.com.mufato.blog.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioService {

    Usuario logInWithEmail(String email, String password);

    Usuario logInWithUser(String username, String password);

    Usuario findUsuarioByNombre(String nombre);

    Optional<Usuario> buscarId(Long id);

    @Transactional
    void insertar(Usuario autor);

    @Transactional
    void eliminar(long idUsuario);

    @Transactional
    void actualizar(Usuario autor);
}
