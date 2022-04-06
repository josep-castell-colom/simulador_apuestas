import java.util.ArrayList;

import exceptions.MyException;

public class App {
    private static boolean on = true;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static boolean getOn() {
        return on;
    }

    public static void setOn() {
        App.on = !on;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        App.usuarios = usuarios;
    }

    public static void main(String[] args) {
        while (on) {
            try {
                Primitiva.creaPrimitiva();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
