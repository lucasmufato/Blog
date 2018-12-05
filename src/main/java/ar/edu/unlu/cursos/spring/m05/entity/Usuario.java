package ar.edu.unlu.cursos.spring.m05.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
    @SequenceGenerator(name = "UserSequence", sequenceName = "UserSequence")
    private Long id;

    @NotBlank
    @Size(min = 2,max = 50)
    @Column(length = 50)
    private String nombre;

    @Column(length = 100)
//    @Pattern("")
    private String mail;

    @NotBlank
    @Size(min = 4,max = 20)
    @Column(length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Seccion> secciones;

    public Usuario(){
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                '}';
    }
}
