package dao;

import java.util.List;

import modelo.Producto;

public interface ProductoDAO {
  void guardar(Producto producto);

  Producto buscarPorId(int id);

  List<Producto> obtenerTodos();

  void actualizar(Producto producto);

  void eliminar(String codigo);
}
