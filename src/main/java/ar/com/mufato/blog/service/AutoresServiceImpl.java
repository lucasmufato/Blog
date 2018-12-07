package ar.com.mufato.blog.service;

import ar.com.mufato.blog.entity.Autor;
import ar.com.mufato.blog.repos.AutoresRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class AutoresServiceImpl implements AutoresService {

    private final AutoresRepository autoresRepository;

    @Inject
    public AutoresServiceImpl(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    @Override
    public List<Autor> traerTodosOrdenadosPorMasReciente() {
        return autoresRepository.findAll(Sort.by("modifiedOn").descending());
    }

    @Override
    public List<Autor> findByNombreContaining(String nombre) {
        return autoresRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Autor> findByApellidoContaining(String apellido) {
        return autoresRepository.findByApellidoContaining(apellido);
    }

    @Override
    public Optional<Autor> buscarId(long id) {
        return autoresRepository.findById(id);
    }

    @Transactional
    @Override
    public void insertar(Autor autor) {
        autoresRepository.save(autor);
    }

    @Transactional
    @Override
    public void eliminar(long idAutor) {
        autoresRepository.deleteById(idAutor);
    }

    @Transactional
    @Override
    public void actualizar(Autor autor) {
        autoresRepository.save(autor);
    }
}
