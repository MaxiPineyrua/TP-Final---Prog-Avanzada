package menu;

import java.util.Scanner;
import dao.CategoriaDAOSQLite;
import modelo.Categoria;
import enums.EstadoCategoria;

public class MenuCategorias {
  private Scanner scanner;
  private CategoriaDAOSQLite categoriaDAO;

  public MenuCategorias() {
    scanner = new Scanner(System.in);
    categoriaDAO = new CategoriaDAOSQLite();
  }

  public void mostrar() {
    int opcion;
    do {
      System.out.println("\n=================================");
      System.out.println("===== GESTIÓN DE CATEGORÍAS =====");
      System.out.println("=================================");
      System.out.println("1. Crear categoría.");
      System.out.println("2. Listar categorías.");
      System.out.println("3. Buscar categoría.");
      System.out.println("4. Actualizar categoría.");
      System.out.println("5. Eliminar categoría.");
      System.out.println("0. Volver al menú principal.");
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          crearCategoria();
          break;
        case 2:
          listarCategorias();
          break;
        case 3:
          buscarCategoria();
          break;
        case 4:
          actualizarCategoria();
          break;
        case 5:
          eliminarCategoria();
          break;
        case 0:
          System.out.println("Volviendo al menú principal...");
          break;
        default:
          System.out.println("Opción inválida. Intente nuevamente.");
      }
    } while (opcion != 0);
  }

  // ------ Crear categoría ------
  private void crearCategoria() {
    System.out.println("\n=== CREAR CATEGORÍA ===");
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Descripción: ");
    String descripcion = scanner.nextLine();

    Categoria categoria = new Categoria(
        0,
        nombre,
        descripcion,
        EstadoCategoria.ACTIVA);
    categoriaDAO.guardar(categoria);
  }

  // ------ Listar categorías ------
  private void listarCategorias() {
    System.out.println("\n=== LISTA DE CATEGORÍAS ===");

    for (Categoria categoria : categoriaDAO.obtenerTodos()) {
      System.out.println(categoria);
    }
  }

  // ------ Buscar categoría por ID ------
  private void buscarCategoria() {
    System.out.println("\n=== BUSCAR CATEGORÍA ===");
    System.out.print("Ingrese ID de la categoría: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Categoria categoria = categoriaDAO.buscarPorId(id);

    if (categoria == null) {
      System.out.println("No se encontró la categoría con ese ID. ");
      return;
    }
    System.out.println("\nCategoría encontrada: ");
    System.out.println(categoria);
  }

  // ------ Actualizar categoría ------
  private void actualizarCategoria() {
    System.out.println("\n=== ACTUALIZAR CATEGORÍA ===");
    System.out.print("Ingrese ID de la categoría: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Categoria categoria = categoriaDAO.buscarPorId(id);

    if (categoria == null) {
      System.out.println("No existe una categoría con ese ID. ");
      return;
    }
    System.out.println("\nCategoría encontrada: ");
    System.out.println(categoria);

    System.out.print("Nuevo nombre: ");
    categoria.setNombre(scanner.nextLine());

    System.out.print("Nueva descripción: ");
    categoria.setDescripcion(scanner.nextLine());

    int opcionEstado;
    while (true) {
      System.out.println("\nEstado:");
      System.out.println("1. ACTIVA");
      System.out.println("2. INACTIVA");
      System.out.print("Seleccione una opción: ");
      opcionEstado = scanner.nextInt();
      scanner.nextLine();

      switch (opcionEstado) {
        case 1:
          categoria.setEstado(EstadoCategoria.ACTIVA);
          break;
        case 2:
          categoria.setEstado(EstadoCategoria.INACTIVA);
          break;
        default:
          System.out.println("Opción inválida. Ingrese 1 o 2.");
          continue;
      }
      break;
    }
    categoriaDAO.actualizar(categoria);
  }

  // ------ Eliminar categoría ------
  private void eliminarCategoria() {
    System.out.println("\n=== ELIMINAR CATEGORÍA ===");
    System.out.print("Ingrese ID de la categoría: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Categoria categoria = categoriaDAO.buscarPorId(id);

    if (categoria == null) {
      System.out.println("No existe una categoría con ese ID. ");
      return;
    }

    System.out.println("\nCategoría encontrada: ");
    System.out.println(categoria);

    System.out.println("\nEstá seguro de que desea eliminar esta categoría? (S/N)");
    String respuesta = scanner.nextLine();

    if (respuesta.equalsIgnoreCase("S")) {
      categoriaDAO.eliminar(id);
    } else {
      System.out.println("Operación cancelada. ");
    }
  }
}