package ar.com.mufato.blog.service;

import ar.com.mufato.blog.entity.Usuario;
import ar.com.mufato.blog.repos.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario logInWithEmail(String email, String password) {
        return this.usuarioRepository.findUsuarioByMailAndPassword(email,password);
    }

    @Override
    public Usuario logInWithUser(String username, String password) {
        return this.usuarioRepository.findUsuarioByNombreAndPassword(username,password);
    }

    @Override
    public Usuario findUsuarioByNombre(String nombre) {
        return this.usuarioRepository.findUsuarioByNombre(nombre);
    }

    @Override
    public Optional<Usuario> buscarId(Long id) {
        return this.usuarioRepository.findById(id);
    }

    @Override
    public void insertar(Usuario autor) {
        this.usuarioRepository.save(autor);
    }

    @Override
    public void eliminar(long idUsuario) {
        this.usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public void actualizar(Usuario autor) {
        this.usuarioRepository.save(autor);
    }
}
