public abstract class Apuesta {
    private Usuario usuario;
    private int num_apuesta;
    private static int contador = 0;
    
    public Apuesta(Usuario usuario) {
        this.setUsuario(usuario);
        this.setNum_apuesta();
    }

    public Apuesta(Apuesta apuesta) {
        this.setUsuario(apuesta.getUsuario());
        this.setNum_apuesta();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Apuesta() {
        this.setNum_apuesta();
    }

    public int getNum_apuesta() {
        return num_apuesta;
    }

    public void setNum_apuesta() {
        contador++;
        this.num_apuesta = contador;
    }

    @Override
    public String toString() {
        return "USUARIO: " + this.getUsuario() +
                "\nNÚMERO DE APUESTA: " + this.getNum_apuesta();
    }

    public void mostrarApuesta() {
        System.out.println(this);
    }
}
