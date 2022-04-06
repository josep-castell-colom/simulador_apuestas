package exceptions;

public class MyException extends Exception {
    private int code;

    public MyException() {
        super();
    }

    public MyException(int code) {
        super();
        this.setCode(code);
    }

    public int getGode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        String msg = "ERROR - ";
        switch (code) {
            case 0:
                msg += "Error indefinido";
                break;
            case 1:
                msg += "Introduce el nombre y los apellidos en mayúsculas";
                break;
            case 2:
                msg += "Todos los números deben estar entre 1 y 49";
                break;
            case 3:
                msg += "Introduce un número";
                break;
        }
        return msg;
    }
}
