package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Producto;

public class ProductoDAOSQLite implements ProductoDAO {

  // ----------- Guardar -----------
  @Override
  public void guardar(Producto producto) {
    String sql = """
        INSERT INTO productos
        (codigo, nombre, descripcion, precio, categoria, stock, peso, estado)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setString(1, producto.getCodigo());
      sentencia.setString(2, producto.getNombre());
      sentencia.setString(3, producto.getDescripcion());
      sentencia.setDouble(4, producto.getPrecio());
      sentencia.setString(5, producto.getCategoria().getNombre());
      sentencia.setInt(6, producto.getStock());
      sentencia.setDouble(7, producto.getPeso());
      sentencia.setString(8, producto.getEstado().toString());

      sentencia.executeUpdate();

      System.out.println("Producto guardado exitosamente. ");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ----------- Buscar por Código -----------
  @Override
  public Producto buscarPorCodigo(String codigo) {
    return null;
  }

  // ----------- Obtener Todos -----------
  @Override
  public List<Producto> obtenerTodos() {
    return null;
  }

  // ----------- Actualizar -----------
  @Override
  public void actualizar(Producto producto) {

    String sql = """
        UPDATE productos
        SET nombre = ?,
            descripcion = ?,
            precio = ?,
            categoria = ?,
            stock = ?,
            peso = ?,
            estado = ?
        WHERE codigo = ?
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setString(1, producto.getNombre());
      sentencia.setString(2, producto.getDescripcion());
      sentencia.setDouble(3, producto.getPrecio());
      sentencia.setString(4, producto.getCategoria().getNombre());
      sentencia.setInt(5, producto.getStock());
      sentencia.setDouble(6, producto.getPeso());
      sentencia.setString(7, producto.getEstado().toString());
      sentencia.setString(8, producto.getCodigo());

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Producto actualizado exitosamente. ");
      } else {
        System.out.println("No se encontro el producto con codigo: " + producto.getCodigo() + ".");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ----------- Eliminar -----------
  @Override
  public void eliminar(String codigo) {
    String sql = "DELETE FROM productos WHERE codigo = ?";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setString(1, codigo);

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Producto eliminado exitosamente. ");
      } else {
        System.out.println("No se encontro el producto con codigo: " + codigo + ".");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}