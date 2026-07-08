package modelo;

public class Calificacion {

  private Usuario cliente;
  private Producto producto;
  private int puntaje;
  private String comentario;

  public Calificacion(Usuario cliente, Producto producto, int puntaje, String comentario) {
    this.cliente = cliente;
    this.producto = producto;
    this.puntaje = puntaje;
    this.comentario = comentario;
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

  public int getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(int puntaje) {
    this.puntaje = puntaje;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  @Override
  public String toString() {
    return "Calificacion{" +
        "cliente=" + cliente +
        ", producto=" + producto +
        ", puntaje=" + puntaje +
        ", comentario='" + comentario + '\'' +
        '}';
  }
}
