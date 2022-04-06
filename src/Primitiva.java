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

  public int getListaNum(int i){
    return listaNum[i];
  }

  public void setListaNum(int[] listaNum) {
    this.listaNum = listaNum;    
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
      while(!valueOk){
        System.out.println("Introduce " + (6 - i) + " números entre el 1 y el 49 (ambos incluidos)");
        if(Tools.input.hasNextInt()){
          int num = Integer.parseInt(Tools.input.nextLine());
          if(!Tools.contains(this.getListaNum(), num)){
            try {
              this.setNum(i, num);
              valueOk = true;
            } catch (MyException e) {
              System.out.println(e.getMessage());
            } catch (Exception e) {
              System.out.println("Introduce un número!");
            }
          }else{
            System.out.println("Numero repetido");
          }
        }else{
          Tools.input.nextLine();
          System.out.println("Introduce un número!");
        }
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
    return "USUARIO: " + this.getUsuario().getNombre() +
        "\nNÚMERO DE APUESTA: " + this.getNum_apuesta() +
        "\nNÚMEROS ELEGIDOS: " + this.getListaNum()[0] + ", " + this.getListaNum()[1] + ", " + this.getListaNum()[2]
        + ", " + this.getListaNum()[3] + ", " + this.getListaNum()[4] + ", " + this.getListaNum()[5] +
        "\nACIERTOS: " + this.getAciertos();
  }

  @Override
  public void mostrarApuesta() {
    System.out.println(this);
  }

  public static void creaPrimitiva(){
    boolean exit = false;
    System.out.println("NUEVA PRIMITIVA");
    try{
      Usuario usuario = Usuario.crearUsuario();
      System.out.println(usuario);
      while (!exit) {
        Primitiva primitiva = new Primitiva();
        primitiva.setListaNum();
        usuario.getPrimitivas().add(primitiva);
        primitiva.setUsuario(usuario);
        System.out.println("[+] Primitiva guardada\n" + primitiva);
        System.out.println("¿Desea realizar otra Primitiva?");
        exit = !Tools.confirmar();
      }
    }catch(MyException e){
      System.out.println(e.getMessage());
    }
  }

  public void compararPrimitiva(int[] random){
    for(int i = 0; i < 6; i ++){
      for(int j = 0; j < 6; j ++){
        if(this.getListaNum(i) == random[j]){
          this.setAciertos(this.getAciertos() + 1);
        }
      }
    }
  }
}
