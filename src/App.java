import dao.BaseDatos;
import menu.MenuPrincipal;

public class App {

    public static void main(String[] args) {
        BaseDatos.crearTablas();

        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciar();
    }
}