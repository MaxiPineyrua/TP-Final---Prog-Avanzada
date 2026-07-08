package modelo;

import java.util.ArrayList;

public class Carrito {

  private Usuario cliente;
  private ArrayList<ItemCarrito> items;

  public Carrito(Usuario cliente) {
    this.cliente = cliente;
    this.items = new ArrayList<>();
  }

  public Usuario getCliente() {
    return cliente;
  }

  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  public ArrayList<ItemCarrito> getItems() {
    return items;
  }

  public void setItems(ArrayList<ItemCarrito> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Carrito{" +
        "cliente=" + cliente +
        ", items=" + items +
        '}';
  }
}
