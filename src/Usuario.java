import java.util.ArrayList;
import java.util.Scanner;

import exceptions.MyException;

public class Usuario {
    private static Scanner input = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    private ArrayList<Primitiva> primitivas;

    public Usuario() {
        this.setPrimitivas(new ArrayList<Primitiva>());
    }

    public Usuario(String nombre, String apellidos, ArrayList<Primitiva> primitivas) throws MyException {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setPrimitivas(primitivas);
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

    public void setApellidos(String apellidos) throws MyException {
        if (apellidos.equals(apellidos.toUpperCase())) {
            this.apellidos = apellidos;
        } else {
            throw new MyException(1);
        }
    }

    public ArrayList<Primitiva> getPrimitivas() {
        return primitivas;
    }

    public void setPrimitivas(ArrayList<Primitiva> primitivas) {
        this.primitivas = primitivas;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + this.getNombre() +
                "\nAPELLIDOS: " + this.getApellidos() +
                "\nPRIMITIVAS: " + this.getPrimitivas();
    }

    public static Usuario crearUsuario() throws MyException {
        Usuario usuario = new Usuario();
        System.out.println("Introduce nombre (en mayúsculas): ");
        usuario.setNombre(input.nextLine());
        System.out.println("Introduce apellidos (en mayúsculas): ");
        usuario.setApellidos(input.nextLine());
        App.setUsuario(usuario);
        return usuario;
    }

}
