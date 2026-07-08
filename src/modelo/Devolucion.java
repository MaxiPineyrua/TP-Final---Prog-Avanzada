package modelo;

import enums.EstadoDevolucion;

public class Devolucion {
  private Usuario cliente;
  private Producto producto;
  private String motivo;
  private String fecha;
  private EstadoDevolucion estado;

  public Devolucion(Usuario cliente, Producto producto, String motivo, String fecha, EstadoDevolucion estado) {
    this.cliente = cliente;
    this.producto = producto;
    this.motivo = motivo;
    this.fecha = fecha;
    this.estado = estado;
  }

  public Usuario getCliente() {
    return cliente;
  }

  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public EstadoDevolucion getEstado() {
    return estado;
  }

  public void setEstado(EstadoDevolucion estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Devolucion{" +
        "cliente=" + cliente +
        ", producto=" + producto +
        ", motivo='" + motivo + '\'' +
        ", fecha='" + fecha + '\'' +
        ", estado='" + estado + '\'' +
        '}';
  }
}
