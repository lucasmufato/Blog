package ar.com.mufato.blog.repos;

import ar.com.mufato.blog.entity.Autor;
import ar.com.mufato.blog.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutor(Autor autor);

    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findByTituloContaining(String titulo);

    List<Libro> findByTituloAndAutor_Apellido(String titulo, String apellido_autor);

    long deleteByIsbn(String isbn);

    List<Libro> removeByTitulo(String titulo);
}
