package dao;

import java.util.List;

import modelo.Usuario;

public interface UsuarioDAO {
  void guardar(Usuario usuario);

  Usuario buscarPorId(int id);

  Usuario buscarPorEmail(String email);

  List<Usuario> obtenerTodos();

  void actualizar(Usuario usuario);

  void eliminar(int id);

}
