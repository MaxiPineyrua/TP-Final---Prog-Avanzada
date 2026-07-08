package modelo;

import enums.EstadoPago;
import enums.MetodoPago;

public class Pago {

  private int id;
  private double monto;
  private MetodoPago metodoPago;
  private EstadoPago estado;

  public Pago(int id, double monto, MetodoPago metodoPago, EstadoPago estado) {
    this.id = id;
    this.monto = monto;
    this.metodoPago = metodoPago;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public MetodoPago getMetodoPago() {
    return metodoPago;
  }

  public void setMetodoPago(MetodoPago metodoPago) {
    this.metodoPago = metodoPago;
  }

  public EstadoPago getEstado() {
    return estado;
  }

  public void setEstado(EstadoPago estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Pago{" +
        "id=" + id +
        ", monto=" + monto +
        ", metodoPago=" + metodoPago +
        ", estado=" + estado +
        '}';
  }
}
