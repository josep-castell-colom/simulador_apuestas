import exceptions.MyException;

public class Primitiva extends Apuesta {
  private int[] listaNum;
  private int aciertos;

  public Primitiva() {
    super();
    this.listaNum = new int[6];
    this.setAciertos(0);
  }

  public Primitiva(Usuario usuario, int[] listaNum) {
    super(usuario);
    this.setListaNum(listaNum);
  }

  public int[] getListaNum() {
    return listaNum;
  }

  public void setListaNum(int[] listaNum) {
    boolean ok = true;
    try {
      for (int i = 0; i < 6; i++) {
        if (listaNum[i] < 1 || listaNum[i] > 49) {
          ok = false;
        }
      }
      if (ok) {
        this.listaNum = listaNum;
      } else {
        throw new MyException(2);
      }
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }

  public void setNum(int posicion, int valor) throws MyException {
    if (posicion >= 0 && posicion < 6) {
      if (valor > 0 && valor < 50) {
        this.getListaNum()[posicion] = valor;
      } else {
        throw new MyException(2);
      }
    } else {
      System.out.println("ERROR - posición no válida (0-5)");
    }
  }

  public void setListaNum() {
    for (int i = 0; i < 6; i++) {
      boolean valueOk = false;
      System.out.println("Introduce " + (6 - i) + " números entre el 1 y el 49 (ambos incluidos)");
      try {
        this.setNum(i, Integer.parseInt(Tools.input.nextLine()));
        valueOk = true;
      } catch (MyException e) {
        Tools.input.nextLine();
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println("Introduce un número!");
      }
      if (!valueOk) {
        i--;
      }
    }
  }

  public int getAciertos() {
    return aciertos;
  }

  public void setAciertos(int aciertos) {
    this.aciertos = aciertos;
  }

  @Override
  public String toString() {
    return "USUARIO: " + this.getUsuario() +
        "\nNÚMERO DE APUESTA: " + this.getNum_apuesta() +
        "\nNÚMEROS ELEGIDOS: " + this.getListaNum()[0] + ", " + this.getListaNum()[1] + ", " + this.getListaNum()[2]
        + ", " + this.getListaNum()[3] + ", " + this.getListaNum()[4] + ", " + this.getListaNum()[5] +
        "\nACIERTOS: " + this.getAciertos();
  }

  @Override
  public void mostrarApuesta() {
    System.out.println(this);
  }

  public static void creaPrimitiva() throws MyException {
    boolean exit = false;
    System.out.println("NUEVA PRIMITIVA");
    Usuario usuario = Usuario.crearUsuario();
    while (!exit) {
      Primitiva primitiva = new Primitiva();
      primitiva.setListaNum();
      usuario.getApuestas().add(primitiva);
      primitiva.setUsuario(usuario);
      System.out.println("Primitiva guardada\n" + primitiva);
      System.out.println("¿Desea realizar otra Primitiva?");
      exit = !Tools.confirmar();
    }
  }
}
