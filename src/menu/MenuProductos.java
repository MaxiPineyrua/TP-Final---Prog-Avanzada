package menu;

import java.util.Scanner;

public class MenuProductos {
  private Scanner scanner;

  public MenuProductos() {
    this.scanner = new Scanner(System.in);
  }

  public void mostrar() {
    int opcion;

    do {
      System.out.println("\n============================");
      System.out.println("=== GESTIÓN DE PRODUCTOS ===");
      System.out.println("============================");
      System.out.println("1. Crear producto.");
      System.out.println("2. Listar productos.");
      System.out.println("3. Buscar producto.");
      System.out.println("4. Actualizar producto.");
      System.out.println("5. Eliminar producto.");
      System.out.println("0. Volver.");
      System.out.print("Ingrese una opcion: ");

      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          System.out.println("Crear producto...");
          break;
        case 2:
          System.out.println("Listar productos...");
          break;
        case 3:
          System.out.println("Buscar producto...");
          break;
        case 4:
          System.out.println("Actualizar producto...");
          break;
        case 5:
          System.out.println("Eliminar producto...");
          break;
        case 0:
          System.out.println("Volviendo al menu principal...");
          break;
        default:
          System.out.println("Opcion invalida. Intente nuevamente.");
      }

    } while (opcion != 0);
  }
}