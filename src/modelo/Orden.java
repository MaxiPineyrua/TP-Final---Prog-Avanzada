package modelo;

import java.util.ArrayList;

import enums.EstadoOrdenCompra;

public class Orden {

  private int numero;
  private Usuario cliente;
  private String fecha;
  private ArrayList<ItemCarrito> productos;
  private double total;
  private EstadoOrdenCompra estado;
  private Pago pagoAsociado;
  private Envio envioAsociado;

  public Orden(int numero, Usuario cliente, String fecha,
      ArrayList<ItemCarrito> productos, double total, EstadoOrdenCompra estado,
      Pago pagoAsociado, Envio envioAsociado) {

    this.numero = numero;
    this.cliente = cliente;
    this.fecha = fecha;
    this.productos = productos;
    this.total = total;
    this.estado = estado;
    this.pagoAsociado = pagoAsociado;
    this.envioAsociado = envioAsociado;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Usuario getCliente() {
    return cliente;
  }

  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public ArrayList<ItemCarrito> getProductos() {
    return productos;
  }

  public void setProductos(ArrayList<ItemCarrito> productos) {
    this.productos = productos;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public EstadoOrdenCompra getEstado() {
    return estado;
  }

  public void setEstado(EstadoOrdenCompra estado) {
    this.estado = estado;
  }

  public Pago getPagoAsociado() {
    return pagoAsociado;
  }

  public void setPagoAsociado(Pago pagoAsociado) {
    this.pagoAsociado = pagoAsociado;
  }

  public Envio getEnvioAsociado() {
    return envioAsociado;
  }

  public void setEnvioAsociado(Envio envioAsociado) {
    this.envioAsociado = envioAsociado;
  }

  @Override
  public String toString() {
    return "Orden{" +
        "numero=" + numero +
        ", cliente=" + cliente +
        ", fecha='" + fecha + '\'' +
        ", productos=" + productos +
        ", total=" + total +
        ", estado=" + estado +
        ", pagoAsociado=" + pagoAsociado +
        ", envioAsociado=" + envioAsociado +
        '}';
  }
}
