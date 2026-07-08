package modelo;

import enums.EstadoUsuario;
import enums.RolUsuario;

public class Usuario {
  private int id;
  private String nombre;
  private String apellido;
  private String email;
  private String contrasena;
  private String fechaAlta;
  private EstadoUsuario estado;
  private RolUsuario rol;

  public Usuario(int id, String nombre, String apellido, String email, String contrasena, String fechaAlta,
      EstadoUsuario estado, RolUsuario rol) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.contrasena = contrasena;
    this.fechaAlta = fechaAlta;
    this.estado = estado;
    this.rol = rol;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getFechaAlta() {
    return fechaAlta;
  }

  public void setFechaAlta(String fechaAlta) {
    this.fechaAlta = fechaAlta;
  }

  public EstadoUsuario getEstado() {
    return estado;
  }

  public void setEstado(EstadoUsuario estado) {
    this.estado = estado;
  }

  public RolUsuario getRol() {
    return rol;
  }

  public void setRol(RolUsuario rol) {
    this.rol = rol;
  }

  @Override
  public String toString() {
    return "Usuario{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", email='" + email + '\'' +
        ", contrasena='" + contrasena + '\'' +
        ", fechaAlta='" + fechaAlta + '\'' +
        ", estado=" + estado +
        ", rol=" + rol +
        '}';
  }
}
