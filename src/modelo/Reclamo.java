package modelo;

import enums.EstadoReclamo;

public class Reclamo {

  private int numeroReclamo;
  private Usuario cliente;
  private Orden pedidoAsociado;
  private String motivo;
  private String fecha;
  private EstadoReclamo estado;

  public Reclamo(int numeroReclamo, Usuario cliente, Orden pedidoAsociado,
      String motivo, String fecha, EstadoReclamo estado) {

    this.numeroReclamo = numeroReclamo;
    this.cliente = cliente;
    this.pedidoAsociado = pedidoAsociado;
    this.motivo = motivo;
    this.fecha = fecha;
    this.estado = estado;
  }

  public int getNumeroReclamo() {
    return numeroReclamo;
  }

  public void setNumeroReclamo(int numeroReclamo) {
    this.numeroReclamo = numeroReclamo;
  }

  public Usuario getCliente() {
    return cliente;
  }

  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  public Orden getPedidoAsociado() {
    return pedidoAsociado;
  }

  public void setPedidoAsociado(Orden pedidoAsociado) {
    this.pedidoAsociado = pedidoAsociado;
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

  public EstadoReclamo getEstado() {
    return estado;
  }

  public void setEstado(EstadoReclamo estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Reclamo{" +
        "numeroReclamo=" + numeroReclamo +
        ", cliente=" + cliente +
        ", pedidoAsociado=" + pedidoAsociado +
        ", motivo='" + motivo + '\'' +
        ", fecha='" + fecha + '\'' +
        ", estado=" + estado +
        '}';
  }
}
