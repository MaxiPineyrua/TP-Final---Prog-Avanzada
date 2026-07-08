package modelo;

import enums.EstadoProducto;

public class ProductoImportado extends Producto {

  public ProductoImportado(String codigo, String nombre, String descripcion,
      double precio, Categoria categoria, int stock,
      double peso, EstadoProducto estado) {

    super(codigo, nombre, descripcion, precio, categoria, stock, peso, estado);
  }

  @Override
  public double calcularPrecioFinal() {
    return getPrecio() * 1.21;
  }

  @Override
  public void mostrarInformacion() {
    System.out.println(this);
  }

  @Override
  public boolean validarDisponibilidad() {
    return getStock() > 0;
  }

  @Override
  public void aplicarDescuento(double porcentaje) {
    setPrecio(getPrecio() - (getPrecio() * porcentaje / 100));
  }

}
