import dao.BaseDatos;
import menu.MenuLogin;
import menu.MenuRol;
import modelo.Usuario;

public class App {

    public static void main(String[] args) {
        BaseDatos.crearTablas();

        MenuLogin login = new MenuLogin();
        Usuario usuario = login.iniciarSesion();

        if (usuario != null) {
            MenuRol menuRol = new MenuRol();
            menuRol.mostrar(usuario);

        } else {
            System.out.println("No se pudo iniciar sesión.");
        }
    }
}