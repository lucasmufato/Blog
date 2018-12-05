package ar.edu.unlu.cursos.spring.m05.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeccionSequence")
    @SequenceGenerator(name = "SeccionSequence", sequenceName = "SeccionSequence")
    Long id;

    @NotBlank
    @Size(min = 2,max = 100, message = "El nombre de la seccion debe tener entre 2 y 100 caracteres")
    String nombre;

    Integer orden;
    @NotNull
    @ColumnDefault("true")
    Boolean publico;

    @ManyToOne(fetch = FetchType.LAZY)
    Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seccion")
    List<Articulo> articulos;

    public Seccion(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seccion seccion = (Seccion) o;
        return Objects.equals(id, seccion.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Seccion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orden=" + orden +
                ", publico=" + publico +
                '}';
    }
}
