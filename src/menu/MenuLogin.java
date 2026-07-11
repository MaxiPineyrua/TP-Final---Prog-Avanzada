package menu;

import dao.UsuarioDAOSQLite;
import modelo.Usuario;
import java.util.Scanner;

public class MenuLogin {
  private Scanner scanner;
  private UsuarioDAOSQLite usuarioDAO;

  public MenuLogin() {
    scanner = new Scanner(System.in);
    usuarioDAO = new UsuarioDAOSQLite();
  }

  public Usuario iniciarSesion() {
    System.out.println("\n=== INICIO DE SESIÓN ===");
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Contraseña: ");
    String contrasena = scanner.nextLine();

    Usuario usuario = usuarioDAO.buscarPorEmail(email);

    if (usuario != null && usuario.getContrasena().equals(contrasena)) {
      System.out.println("\nBienvenido " + usuario.getNombre() + "!");
      return usuario;
    } else {
      System.out.println("Email o contraseña incorrectos. ");
      return null;
    }
  }
}