package menu;

import modelo.Usuario;
import enums.RolUsuario;

public class MenuRol {
  public void mostrar(Usuario usuario) {
    if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
      System.out.println("\n=== MENU DE ADMINISTRADOR ===");
      System.out.println("Puede gestionar usuarios, productos, categorías, inventario y reportes.");

    } else if (usuario.getRol() == RolUsuario.CLIENTE) {
      System.out.println("\n=== MENU DE CLIENTE ===");
      System.out.println("Puede consultar productos, carrito, compras pedidos y reclamos.");

    } else if (usuario.getRol() == RolUsuario.OPERADOR_VENTAS) {
      System.out.println("\n=== MENU DE OPERADOR DE VENTAS ===");
      System.out.println("Puede administrar órdenes, pagos y estados de pedidos.");

    } else if (usuario.getRol() == RolUsuario.RESPONSABLE_LOGISTICA) {
      System.out.println("\n=== MENU DE RESPONSABLE DE LOGISTICA ===");
      System.out.println("Puede gestionar envíos y estados de entrega.");
    }
  }
}
