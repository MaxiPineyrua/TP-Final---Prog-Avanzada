package menu;

import java.util.Scanner;
import dao.UsuarioDAOSQLite;
import enums.EstadoUsuario;
import enums.RolUsuario;
import modelo.Usuario;

public class MenuUsuarios {
  private Scanner scanner;
  private UsuarioDAOSQLite usuarioDAO;

  public MenuUsuarios() {
    scanner = new Scanner(System.in);
    usuarioDAO = new UsuarioDAOSQLite();
  }

  public void mostrar() {
    int opcion;

    do {
      System.out.println("\n===========================");
      System.out.println("=== GESTIÓN DE USUARIOS ===");
      System.out.println("===========================");
      System.out.println("1. Crear usuario");
      System.out.println("2. Listar usuarios");
      System.out.println("3. Buscar usuario");
      System.out.println("4. Actualizar usuario");
      System.out.println("5. Eliminar usuario");
      System.out.println("0. Volver al menú principal");
      System.out.print("\nSeleccione una opción: ");
      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          crearUsuario();
          break;
        case 2:
          listarUsuarios();
          break;
        case 3:
          buscarUsuario();
          break;
        case 4:
          actualizarUsuario();
          break;
        case 5:
          eliminarUsuario();
          break;
        case 0:
          System.out.println("Volviendo al menú principal...");
          break;
        default:
          System.out.println("Opción inválida. Intente nuevamente.");
      }
    } while (opcion != 0);
  }

  // ------ Crear Usuario ------
  private void crearUsuario() {
    System.out.println("\n=== CREAR USUARIO ===");
    String nombre = leerNombre();
    String apellido = leerApellido();
    String email = leerEmail();
    String contrasena = leerContrasena();
    String fechaAlta = java.time.LocalDate.now().toString();
    EstadoUsuario estado = EstadoUsuario.ACTIVO;

    System.out.println("\nSeleccione el rol: ");
    System.out.println("1. Cliente");
    System.out.println("2. Administrador");
    System.out.println("3. Operador de Ventas");
    System.out.println("4. Responsable de Logística");
    System.out.print("\nOpción: ");

    int opcionRol = scanner.nextInt();
    scanner.nextLine();

    RolUsuario rol;

    switch (opcionRol) {
      case 1:
        rol = RolUsuario.CLIENTE;
        break;
      case 2:
        rol = RolUsuario.ADMINISTRADOR;
        break;
      case 3:
        rol = RolUsuario.OPERADOR_VENTAS;
        break;
      case 4:
        rol = RolUsuario.RESPONSABLE_LOGISTICA;
        break;
      default:
        System.out.println("Rol Inválido.");
        return;
    }

    Usuario usuario = new Usuario(
        0,
        nombre,
        apellido,
        email,
        contrasena,
        fechaAlta,
        estado,
        rol);

    usuarioDAO.guardar(usuario);

    System.out.println("Usuario creado exitosamente.");
  }

  // ------ Nombre ------
  private String leerNombre() {
    while (true) {
      System.out.print("Nombre: ");
      String nombre = scanner.nextLine().trim();

      if (nombre.isEmpty()) {
        System.out.println("El nombre no puede estar vacío.");
        continue;
      }
      if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        System.out.println("El nombre solo puede contener letras.");
        continue;
      }
      return nombre;
    }
  }

  // ------ Apellido ------
  private String leerApellido() {
    while (true) {
      System.out.print("Apellido: ");
      String apellido = scanner.nextLine().trim();

      if (apellido.isEmpty()) {
        System.out.println("El apellido no puede estar vacío.");
        continue;
      }
      if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        System.out.println("El apellido solo puede contener letras.");
        continue;
      }
      return apellido;
    }
  }

  // ------ Email ------
  private String leerEmail() {
    while (true) {
      System.out.print("Email: ");
      String email = scanner.nextLine().trim();

      if (email.isEmpty()) {
        System.out.println("El email no puede estar vacío.");
        continue;
      }
      if (!email.contains("@") || !email.contains(".")) {
        System.out.println("El email debe contener @ y .");
        continue;
      }
      if (usuarioDAO.buscarPorEmail(email) != null) {
        System.out.println("Ya existe un usuario con ese email.");
        continue;
      }
      return email;
    }
  }

  // ------ Contraseña ------
  private String leerContrasena() {
    while (true) {
      System.out.print("Contraseña: ");
      String contrasena = scanner.nextLine().trim();

      if (contrasena.isEmpty()) {
        System.out.println("La contraseña no puede estar vacía.");
        continue;
      }
      if (contrasena.length() < 6) {
        System.out.println("La contraseña debe tener al menos 6 caracteres.");
        continue;
      }
      return contrasena;
    }
  }

  // ------ Listar Usuarios ------
  private void listarUsuarios() {
    System.out.println("\n=== LISTAR USUARIOS ===");
    var usuarios = usuarioDAO.obtenerTodos();

    if (usuarios.isEmpty()) {
      System.out.println("No hay usuarios registrados.");
      return;
    }

    for (Usuario usuario : usuarios) {
      System.out.println("-------------------------------");
      System.out.println("ID: " + usuario.getId());
      System.out.println("Nombre: " + usuario.getNombre());
      System.out.println("Apellido: " + usuario.getApellido());
      System.out.println("Email: " + usuario.getEmail());
      System.out.println("Fecha de Alta: " + usuario.getFechaAlta());
      System.out.println("Estado: " + usuario.getEstado());
      System.out.println("Rol: " + usuario.getRol());
    }
  }

  // ------ Buscar Usuario ------
  private void buscarUsuario() {
    System.out.println("\n=== BUSCAR USUARIO ===");
    System.out.print("Ingrese el email del usuario: ");
    String email = scanner.nextLine();

    Usuario usuario = usuarioDAO.buscarPorEmail(email);

    if (usuario == null) {
      System.out.println("No se encontró ningún usuario con el email " + email + ".");
      return;
    }

    System.out.println("\nUsuario encontrado:");
    System.out.println("-------------------------------");
    System.out.println("ID: " + usuario.getId());
    System.out.println("Nombre: " + usuario.getNombre());
    System.out.println("Apellido: " + usuario.getApellido());
    System.out.println("Email: " + usuario.getEmail());
    System.out.println("Fecha de Alta: " + usuario.getFechaAlta());
    System.out.println("Estado: " + usuario.getEstado());
    System.out.println("Rol: " + usuario.getRol());
  }

  // ------ Actualizar Usuario ------
  private void actualizarUsuario() {
    System.out.println("\n=== ACTUALIZAR USUARIO ===");
    System.out.print("Ingrese el email del usuario: ");
    String email = scanner.nextLine();

    Usuario usuario = usuarioDAO.buscarPorEmail(email);

    if (usuario == null) {
      System.out.println("No se encontró ningún usuario con el email " + email + ".");
      return;
    }

    System.out.println("\nUsuario encontrado:");
    System.out.println(usuario);
    System.out.println("-------------------------------");
    System.out.println("\nIngrese los nuevos datos: ");
    String nombre = leerNombre();
    String apellido = leerApellido();
    String contrasena = leerContrasena();

    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    usuario.setContrasena(contrasena);

    System.out.println("\nSeleccione un nuevo estado: ");
    System.out.println("1. ACTIVO");
    System.out.println("2. INACTIVO");
    System.out.print("Opción: ");

    int opcionEstado = scanner.nextInt();
    scanner.nextLine();

    if (opcionEstado == 1) {
      usuario.setEstado(EstadoUsuario.ACTIVO);
    } else if (opcionEstado == 2) {
      usuario.setEstado(EstadoUsuario.INACTIVO);
    } else {
      System.out.println("Estado inválido. Se mantendrá el estado actual.");
    }

    System.out.println("\nSeleccione un nuevo rol: ");
    System.out.println("1. CLIENTE");
    System.out.println("2. ADMINISTRADOR");
    System.out.println("3. OPERADOR_VENTAS");
    System.out.println("4. RESPONSABLE_LOGISTICA");
    System.out.print("Opción: ");

    int opcionRol = scanner.nextInt();
    scanner.nextLine();

    switch (opcionRol) {
      case 1:
        usuario.setRol(RolUsuario.CLIENTE);
        break;
      case 2:
        usuario.setRol(RolUsuario.ADMINISTRADOR);
        break;
      case 3:
        usuario.setRol(RolUsuario.OPERADOR_VENTAS);
        break;
      case 4:
        usuario.setRol(RolUsuario.RESPONSABLE_LOGISTICA);
        break;
      default:
        System.out.println("Rol inválido. Se mantendrá el rol actual.");
        break;
    }
    usuarioDAO.actualizar(usuario);

    System.out.println("\nUsuario actualizado exitosamente.");
    System.out.println("ID: " + usuario.getId());
    System.out.println("Nombre: " + usuario.getNombre());
    System.out.println("Apellido: " + usuario.getApellido());
    System.out.println("Email: " + usuario.getEmail());
    System.out.println("Fecha de Alta: " + usuario.getFechaAlta());
    System.out.println("Estado: " + usuario.getEstado());
    System.out.println("Rol: " + usuario.getRol());
  }

  // ------ Eliminar Usuario ------
  private void eliminarUsuario() {
    System.out.println("\n=== ELIMINAR USUARIO ===");
    System.out.print("Ingrese el email del usuario: ");
    String email = scanner.nextLine();

    Usuario usuario = usuarioDAO.buscarPorEmail(email);

    if (usuario == null) {
      System.out.println("No se encontró ningún usuario con el email " + email + ".");
      return;
    }

    System.out.println("\nUsuario encontrado:");
    System.out.println(usuario);
    System.out.println("-------------------------------");
    System.out.print("¿Está seguro de que desea eliminar este usuario? (S/N): ");
    String respuesta = scanner.nextLine();

    if (respuesta.equalsIgnoreCase("S")) {
      usuarioDAO.eliminar(usuario.getId());
    } else {
      System.out.println("Operación cancelada.");
    }
  }
}