import java.util.Scanner;

public class InputValueValidator {

    public double leerDoubleEnRango(String msg, Scanner sc, double min, double max) {
        double value;
        while (true) {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El valor debe estar entre " + min + " y " + max);
            } else {
                System.out.println("El dato no es numérico");
                sc.next();
            }
        }
    }

    public int leerIntEnRango(String msg, Scanner sc, int min, int max) {
        int value;
        while (true) {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El número esta fuera de rango");
            } else {
                System.out.println("El dato no es numerico");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(String msg, Scanner sc) {
        while (true) {
            System.out.print(msg + " (true-false): ");
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("El dato no es booleano (eliga true o false)");
                sc.next();
            }
        }
    }
}