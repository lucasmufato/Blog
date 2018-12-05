package ar.edu.unlu.cursos.spring.m05.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Tag {

    @Id
    @NotBlank
    @Size(min = 2,max = 15,message = "El tag debe tener entre 2 y 15 caracteres")
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Articulo> articulos;

    public Tag(){

    }

    public Tag(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(nombre, tag.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }
}
