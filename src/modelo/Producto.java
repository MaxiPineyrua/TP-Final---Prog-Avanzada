package modelo;

import enums.EstadoProducto;

public abstract class Producto {
  private String codigo;
  private String nombre;
  private String descripcion;
  private double precio;
  private Categoria categoria;
  private int stock;
  private double peso;
  private EstadoProducto estado;

  public Producto(String codigo, String nombre, String descripcion, double precio, Categoria categoria, int stock,
      double peso, EstadoProducto estado) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.categoria = categoria;
    this.stock = stock;
    this.peso = peso;
    this.estado = estado;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public EstadoProducto getEstado() {
    return estado;
  }

  public void setEstado(EstadoProducto estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "codigo='" + codigo + "\'" +
        ", nombre='" + nombre + "\'" +
        ", descripcion='" + descripcion + "\'" +
        ", precio='" + precio +
        ", categoria='" + categoria +
        ", stock='" + stock +
        ", peso='" + peso +
        ", estado='" + estado +
        "}";
  }

  public abstract double calcularPrecioFinal();

  public abstract void mostrarInformacion();

  public abstract boolean validarDisponibilidad();

  public abstract void aplicarDescuento(double porcentaje);
}
