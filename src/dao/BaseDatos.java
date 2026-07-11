package dao;

import java.sql.Connection;
import java.sql.Statement;

public class BaseDatos {

  public static void crearTablas() {

    try (Connection conexion = ConexionSQLite.conectar();
        Statement statement = conexion.createStatement()) {

      // Tabla de usuarios
      String sqlUsuario = """
            CREATE TABLE IF NOT EXISTS usuarios (
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              nombre TEXT NOT NULL,
              apellido TEXT NOT NULL UNIQUE,
              email TEXT NOT NULL,
              contrasena TEXT NOT NULL,
              fechaAlta TEXT NOT NULL,
              estado TEXT NOT NULL,
              rol TEXT NOT NULL
            )
          """;
      statement.execute(sqlUsuario);

      System.out.println("\nTabla usuarios creada exitosamente. ");

      // Tabla de productos
      String sqlProducto = """
            CREATE TABLE IF NOT EXISTS productos (
              codigo text PRIMARY KEY,
              nombre TEXT NOT NULL,
              descripcion TEXT NOT NULL,
              precio REAL NOT NULL,
              categoria TEXT NOT NULL,
              stock INTEGER NOT NULL,
              peso REAL NOT NULL,
              estado TEXT NOT NULL
            )
          """;

      statement.execute(sqlProducto);

      System.out.println("Tabla productos creada exitosamente. ");

      // Tabla de categorías
      String sqlCategoria = """
            CREATE TABLE IF NOT EXISTS categorias (
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              nombre TEXT NOT NULL,
              descripcion TEXT NOT NULL,
              estado TEXT NOT NULL
            )
          """;
      statement.execute(sqlCategoria);

      System.out.println("Tabla categorías creada exitosamente. ");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
