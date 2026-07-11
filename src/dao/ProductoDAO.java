package dao;

import java.util.List;

import modelo.Producto;

public interface ProductoDAO {
  void guardar(Producto producto);

  Producto buscarPorCodigo(String codigo);

  List<Producto> obtenerTodos();

  void actualizar(Producto producto);

  void eliminar(String codigo);
}
