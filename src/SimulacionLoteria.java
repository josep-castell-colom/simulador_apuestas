import java.util.Random;

import exceptions.MyException;

public class SimulacionLoteria {
    public static int[] generarPrimitivaRandom(){
        int[] primitiva = new int[6];
        for(int i = 0; i < 6; i ++){
            boolean ok = false;
            while(!ok){
                Random rand = new Random();
                int num = rand.nextInt(49) + 1;
                if(!Tools.contains(primitiva, num)){
                    primitiva[i] = num;
                    ok = true;
                }
            }
        }
        return primitiva;
    }

    public static void realizarSimulacion(){
        System.out.println("REALIZAR SIMULACIÓN");
        int times = 0;
        boolean ok = false;
        while(!ok){
            System.out.println("¿Cuantas veces desa probar suerte?(Introduce un número)");
            try{
                if(Tools.input.hasNextInt()){
                    times = Integer.parseInt(Tools.input.nextLine());
                    ok = true;
                }else{
                    Tools.input.nextLine();
                    throw new MyException(3);
                }
            }catch(MyException e){
                System.out.println(e.getMessage());
            }
        }
        for(int j = 0; j < App.getUsuario().getPrimitivas().size(); j++){
            System.out.println("PRIMITIVA:");
            System.out.println(App.getUsuario().getPrimitivas().get(j));
            int ceroAciertos = 0;
            int unAcierto = 0;
            int dosAciertos = 0;
            int tresAciertos = 0;
            int cuatroAciertos = 0;
            int cincoAciertos = 0;
            int seisAciertos = 0;
            for(int i = 0; i < times; i ++){
                int[] random = generarPrimitivaRandom();
                App.getUsuario().getPrimitivas().get(j).compararPrimitiva(random);
                System.out.println("---------------------\n");
                System.out.println("Combinación ganadora:\n" + random[0] + "-" + random[1] + "-" + random[2] + "-" + random[3] + "-" + random[4] + "-" + random[5]);
                System.out.println("Aciertos: " + App.getUsuario().getPrimitivas().get(j).getAciertos() + "\n");
                switch(App.getUsuario().getPrimitivas().get(j).getAciertos()){
                    case 0: ceroAciertos += 1;
                    break;
                    case 1: unAcierto += 1;
                    break;
                    case 2: dosAciertos += 1;
                    break;
                    case 3: tresAciertos += 1;
                    break;
                    case 4: cuatroAciertos += 1;
                    break;
                    case 5: cincoAciertos += 1;
                    break;
                    case 6: seisAciertos += 1;
                    break;
                }
                App.getUsuario().getPrimitivas().get(j).setAciertos(0);
            }
            System.out.println("0 aciertos: " + ceroAciertos);
            System.out.println("1 acierto: " + unAcierto);
            System.out.println("2 aciertos: " + dosAciertos);
            System.out.println("3 aciertos: " + tresAciertos);
            System.out.println("4 aciertos: " + cuatroAciertos);
            System.out.println("5 aciertos: " + cincoAciertos);
            System.out.println("6 aciertos: " + seisAciertos);
        }
    }


    public static void menu(){
        boolean on = true;
        while(on){
            System.out.println("-----------------------");
            System.out.println("Elige una opción:");
            System.out.println("1 - Crear Primitiva");
            System.out.println("2 - Mostrar usuario");
            System.out.println("3 - Realizar simulación");
            System.out.println("0 - Salir");

            String opt = Tools.input.nextLine();

            switch(opt){
                case "1": Primitiva.creaPrimitiva();
                break;
                case "2": System.out.println(App.getUsuario());
                break;
                case "3": realizarSimulacion();
                break;
                case "0": on = false;
                break;
                case default: System.out.println("Introduce una de las opciones disponibles.");
                break;
            }
        }
    }
}
