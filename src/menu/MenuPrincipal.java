package menu;

import java.util.Scanner;

public class MenuPrincipal {

  private Scanner scanner;

  public MenuPrincipal() {
    scanner = new Scanner(System.in);
  }

  public void iniciar() {
    int opcion;

    do {
      System.out.println("\n==========================");
      System.out.println("=== SISTEMA E-COMMERCE ===");
      System.out.println("==========================");
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
      System.out.println("13. Salir");
      System.out.print("\nSeleccione una opción: ");
      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          System.out.println("\nFunción en construcción...");
          break;
        case 2:
          System.out.println("\nFunción en construcción...");
          break;
        case 3:
          System.out.println("\nFunción en construcción...");
          break;
        case 4:
          System.out.println("\nFunción en construcción...");
          break;
        case 5:
          System.out.println("\nFunción en construcción...");
          break;
        case 6:
          System.out.println("\nFunción en construcción...");
          break;
        case 7:
          System.out.println("\nFunción en construcción...");
          break;
        case 8:
          System.out.println("\nFunción en construcción...");
          break;
        case 9:
          System.out.println("\nFunción en construcción...");
          break;
        case 10:
          System.out.println("\nFunción en construcción...");
          break;
        case 11:
          System.out.println("\nFunción en construcción...");
          break;
        case 12:
          System.out.println("\nFunción en construcción...");
          break;
        case 13:
          System.out.println("Hasta luego!");
          break;
        default:
          System.out.println("Opción inválida. Intente nuevamente.");
      }
    } while (opcion != 13);

    scanner.close();
  }
}
