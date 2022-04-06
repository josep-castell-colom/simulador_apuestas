import java.util.Scanner;

public class Tools {
    public static Scanner input = new Scanner(System.in);

    public static boolean confirmar() {
        boolean confirmar = false;
        System.out.println("(s/n)");
        String opt = "";
        do {
            opt = input.nextLine();
            if (opt.equalsIgnoreCase("s")) {
                confirmar = true;
            } else if (opt.equalsIgnoreCase("n")) {

            } else {
                System.out.println("Introduce 's' o 'n'");
            }
        } while (!opt.equalsIgnoreCase("s") && !opt.equalsIgnoreCase("n"));
        return confirmar;
    }
}
