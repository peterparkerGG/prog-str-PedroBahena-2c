import java.util.Scanner;

public class Validator {

    public int getIntNumber(Scanner sc, String msg) {
        int numero;
        while (true) {
            try {
                System.out.print(msg);
                numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.println("Numero invalido");
                sc.nextLine();
            }
        }
    }
}
