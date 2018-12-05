package ar.edu.unlu.cursos.spring.m05.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ArticuloSequence")
    @SequenceGenerator(name = "ArticuloSequence", sequenceName = "ArticuloSequence")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(length = 100)
    private String titulo;

    @NotNull
    @ColumnDefault("true")
    private Boolean publico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @NotNull
    private Seccion seccion;

    @OneToMany(mappedBy = "articulo")
    private List<Parrafo> parrafos;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

    public Articulo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Parrafo> getParrafos() {
        return parrafos;
    }

    public void setParrafos(List<Parrafo> parrafos) {
        this.parrafos = parrafos;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", publico=" + publico +
                '}';
    }
}
