public class App {
    private static boolean on = true;
    private static Usuario currentUser;

    public static boolean getOn() {
        return on;
    }

    public static void setOn() {
        App.on = !on;
    }

    public static Usuario getUsuario() {
        return currentUser;
    }

    public static void setUsuario(Usuario usuario) {
        App.currentUser = usuario;
    }

    public static void main(String[] args) {
        SimulacionLoteria.menu();
    }
}
