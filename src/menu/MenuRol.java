package menu;

import modelo.Usuario;
import enums.RolUsuario;
import java.util.Scanner;

public class MenuRol {
  public void mostrar(Usuario usuario) {
    // ----- Menú para Administradores -----
    if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
      Scanner scanner = new Scanner(System.in);
      int opcion;

      do {
        System.out.println("\n=============================");
        System.out.println("=== MENU DE ADMINISTRADOR ===");
        System.out.println("=============================");
        System.out.println("1. Gestión de Usuarios");
        System.out.println("2. Gestión de Roles");
        System.out.println("3. Gestión de Productos");
        System.out.println("4. Gestión de Categorías");
        System.out.println("5. Gestión de Inventario");
        System.out.println("6. Carrito de Compras");
        System.out.println("7. Órdenes de Compra");
        System.out.println("8. Procesamiento de Pagos");
        System.out.println("9. Gestión de Envíos");
        System.out.println("10. Seguimiento de Pedidos");
        System.out.println("11. Reclamos y Devoluciones");
        System.out.println("12. Reportes");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
          case 1:
            MenuUsuarios menuUsuarios = new MenuUsuarios();
            menuUsuarios.mostrar();
            break;
          case 2:
            System.out.println("\n=== Gestión de Roles ===");
            break;
          case 3:
            new MenuProductos().mostrar();
            break;
          case 4:
            new MenuCategorias().mostrar();
            break;
          case 5:
            System.out.println("\n=== Gestión de Inventario ===");
            break;
          case 6:
            System.out.println("\n=== Carrito de Compras ===");
            break;
          case 7:
            System.out.println("\n=== Órdenes de Compra ===");
            break;
          case 8:
            System.out.println("\n=== Procesamiento de Pagos ===");
            break;
          case 9:
            System.out.println("\n=== Gestión de Envíos ===");
            break;
          case 10:
            System.out.println("\n=== Seguimiento de Pedidos ===");
            break;
          case 11:
            System.out.println("\n=== Reclamos y Devoluciones ===");
            break;
          case 12:
            System.out.println("\n=== Reportes ===");
            break;
          case 0:
            System.out.println("Hasta luego!");
            break;
          default:
            System.out.println("Opción inválida. Intente nuevamente.");
        }
      } while (opcion != 0);

      // ----- Menú para Clientes -----
    } else if (usuario.getRol() == RolUsuario.CLIENTE) {
      System.out.println("\n=== MENU DE CLIENTE ===");
      System.out.println("Puede consultar productos, carrito, compras pedidos y reclamos.");

      // ----- Menú para Operadores de Ventas -----
    } else if (usuario.getRol() == RolUsuario.OPERADOR_VENTAS) {
      System.out.println("\n=== MENU DE OPERADOR DE VENTAS ===");
      System.out.println("Puede administrar órdenes, pagos y estados de pedidos.");

      // ----- Menú para Responsables de Logística -----
    } else if (usuario.getRol() == RolUsuario.RESPONSABLE_LOGISTICA) {
      System.out.println("\n=== MENU DE RESPONSABLE DE LOGISTICA ===");
      System.out.println("Puede gestionar envíos y estados de entrega.");
    }
  }
}