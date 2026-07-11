package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.Categoria;
import java.util.ArrayList;
import java.sql.ResultSet;
import enums.EstadoCategoria;

public class CategoriaDAOSQLite implements CategoriaDAO {

  // ------ Guardar categoría ------
  @Override
  public void guardar(Categoria categoria) {
    String sql = """
        INSERT INTO categorias
        (nombre, descripcion, estado)
        VALUES (?, ?, ?)
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement statement = conexion.prepareStatement(sql)) {

      statement.setString(1, categoria.getNombre());
      statement.setString(2, categoria.getDescripcion());
      statement.setString(3, categoria.getEstado().toString());

      statement.executeUpdate();

      System.out.println("Categoría guardada exitosamente.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ------ Obtener todas las categorías ------
  @Override
  public List<Categoria> obtenerTodos() {
    List<Categoria> categorias = new ArrayList<>();
    String sql = "SELECT * FROM categorias";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement statement = conexion.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery()) {

      while (resultado.next()) {
        Categoria categoria = new Categoria(
            resultado.getInt("id"),
            resultado.getString("nombre"),
            resultado.getString("descripcion"),
            EstadoCategoria.valueOf(resultado.getString("estado")));
        categorias.add(categoria);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return categorias;
  }

  // ------ Buscar categoría por ID ------
  @Override
  public Categoria buscarPorId(int id) {
    String sql = "SELECT * FROM categorias WHERE id = ?";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {
      sentencia.setInt(1, id);
      ResultSet resultado = sentencia.executeQuery();

      if (resultado.next()) {
        return new Categoria(
            resultado.getInt("id"),
            resultado.getString("nombre"),
            resultado.getString("descripcion"),
            EstadoCategoria.valueOf(resultado.getString("estado")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  // ------ Actualizar categoría ------
  @Override
  public void actualizar(Categoria categoria) {
    String sql = """
        UPDATE categorias
        SET nombre = ?,
        descripcion = ?,
        estado = ?
        WHERE id = ?
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setString(1, categoria.getNombre());
      sentencia.setString(2, categoria.getDescripcion());
      sentencia.setString(3, categoria.getEstado().toString());
      sentencia.setInt(4, categoria.getId());

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Categoría actualizada exitosamente.");
      } else {
        System.out.println("No se encontró la categoría con ID: " + categoria.getId() + ".");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ------ Eliminar categoría ------
  @Override
  public void eliminar(int id) {
    String sql = "DELETE FROM categorias WHERE id = ?";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setInt(1, id);

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Categoría eliminada exitosamente.");
      } else {
        System.out.println("No se encontró la categoría con ID: " + id + ".");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}