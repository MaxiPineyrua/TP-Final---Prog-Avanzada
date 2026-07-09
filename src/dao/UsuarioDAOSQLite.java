package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import enums.EstadoUsuario;
import enums.RolUsuario;

import modelo.Usuario;

public class UsuarioDAOSQLite implements UsuarioDAO {

  // ----------- Guardar -----------
  @Override
  public void guardar(Usuario usuario) {
    String sql = """
        INSERT INTO usuarios
        (id, nombre, apellido, email, contrasena, fechaAlta, estado, rol)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setInt(1, usuario.getId());
      sentencia.setString(2, usuario.getNombre());
      sentencia.setString(3, usuario.getApellido());
      sentencia.setString(4, usuario.getEmail());
      sentencia.setString(5, usuario.getContrasena());
      sentencia.setString(6, usuario.getFechaAlta());
      sentencia.setString(7, usuario.getEstado().toString());
      sentencia.setString(8, usuario.getRol().toString());

      sentencia.executeUpdate();

      System.out.println("Usuario guardado exitosamente. ");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ----------- Buscar por ID -----------
  @Override
  public Usuario buscarPorId(int id) {
    String sql = "SELECT * FROM usuarios WHERE id = ?";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setInt(1, id);

      ResultSet resultado = sentencia.executeQuery();

      if (resultado.next()) {

        Usuario usuario = new Usuario(
            resultado.getInt("id"),
            resultado.getString("nombre"),
            resultado.getString("apellido"),
            resultado.getString("email"),
            resultado.getString("contrasena"),
            resultado.getString("fechaAlta"),
            EstadoUsuario.valueOf(resultado.getString("estado")),
            RolUsuario.valueOf(resultado.getString("rol")));

        return usuario;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  // ----------- Obtener Todos -----------
  @Override
  public List<Usuario> obtenerTodos() {
    List<Usuario> usuarios = new ArrayList<>();

    String sql = "SELECT * FROM usuarios";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery()) {

      while (resultado.next()) {

        Usuario usuario = new Usuario(
            resultado.getInt("id"),
            resultado.getString("nombre"),
            resultado.getString("apellido"),
            resultado.getString("email"),
            resultado.getString("contrasena"),
            resultado.getString("fechaAlta"),
            EstadoUsuario.valueOf(resultado.getString("estado")),
            RolUsuario.valueOf(resultado.getString("rol")));

        usuarios.add(usuario);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return usuarios;
  }

  // ----------- Actualizar -----------
  @Override
  public void actualizar(Usuario usuario) {

    String sql = """
        UPDATE usuarios
        SET nombre = ?,
            apellido = ?,
            email = ?,
            contrasena = ?,
            fechaAlta = ?,
            estado = ?,
            rol = ?
        WHERE id = ?
        """;

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setString(1, usuario.getNombre());
      sentencia.setString(2, usuario.getApellido());
      sentencia.setString(3, usuario.getEmail());
      sentencia.setString(4, usuario.getContrasena());
      sentencia.setString(5, usuario.getFechaAlta());
      sentencia.setString(6, usuario.getEstado().toString());
      sentencia.setString(7, usuario.getRol().toString());
      sentencia.setInt(8, usuario.getId());

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Usuario actualizado exitosamente. ");
      } else {
        System.out.println("No se encontró ningún usuario con el ID " + usuario.getId() + ".");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ----------- Eliminar -----------
  @Override
  public void eliminar(int id) {

    String sql = "DELETE FROM usuarios WHERE id = ?";

    try (Connection conexion = ConexionSQLite.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {

      sentencia.setInt(1, id);

      int filas = sentencia.executeUpdate();

      if (filas > 0) {
        System.out.println("Usuario eliminado exitosamente. ");
      } else {
        System.out.println("No se encontró ningún usuario con el ID " + id + ".");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
