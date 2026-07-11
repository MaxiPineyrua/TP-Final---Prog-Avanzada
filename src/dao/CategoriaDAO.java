package dao;

import java.util.List;
import modelo.Categoria;

public interface CategoriaDAO {

  void guardar(Categoria categoria);

  Categoria buscarPorId(int id);

  List<Categoria> obtenerTodos();

  void actualizar(Categoria categoria);

  void eliminar(int id);
}
