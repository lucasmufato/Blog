package ar.com.mufato.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Parrafo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParrafoSequence")
    @SequenceGenerator(name = "ParrafoSequence", sequenceName = "ParrafoSequence")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 1000, message = "El parrafo debe tener entre 2 y 1000 caracteres.")
    @Column(length = 1000)
    private String contenido;
    private Integer orden;

    @NotNull
    private ParrafoType tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @NotNull
    private Articulo articulo;

    public Parrafo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public ParrafoType getTipo() {
        return tipo;
    }

    public void setTipo(ParrafoType tipo) {
        this.tipo = tipo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Parrafo{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", orden=" + orden +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parrafo parrafo = (Parrafo) o;
        return Objects.equals(id, parrafo.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
