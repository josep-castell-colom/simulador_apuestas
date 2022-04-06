import java.util.ArrayList;
import java.util.Scanner;

import exceptions.MyException;

public class Usuario {
    private static Scanner input = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    private ArrayList<Apuesta> apuestas;

    public Usuario() {
        this.setApuestas(new ArrayList<Apuesta>());
    }

    public Usuario(String nombre, String apellidos, ArrayList<Apuesta> apuestas) throws MyException {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setApuestas(apuestas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws MyException {
        if (nombre.equals(nombre.toUpperCase())) {
            this.nombre = nombre;
        } else {
            throw new MyException(1);
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        try {
            if (apellidos.equals(apellidos.toUpperCase())) {
                this.apellidos = apellidos;
            } else {
                throw new MyException(1);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + this.getNombre() +
                "\nAPELLIDOS: " + this.getApellidos();
    }

    public static Usuario crearUsuario() throws MyException {
        Usuario usuario = new Usuario();
        System.out.println("Introduce nombre (en mayúsculas): ");
        usuario.setNombre(input.nextLine());
        System.out.println("Introduce apellidos (en mayúsculas): ");
        usuario.setApellidos(input.nextLine());
        App.getUsuarios().add(usuario);
        return usuario;
    }

}
