import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int edad;
        double tarifa = 0;
        boolean esEstudiante;
        System.out.println("Ingrese su edad:");
        edad = leer.nextInt();
        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            System.exit(0);
        }
        System.out.println("Eres estudiante? (true/false):");
        esEstudiante = leer.nextBoolean();
        if (edad < 12) {
            tarifa = 50;
        }
        else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        }
        else if (edad >= 18) {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }
        System.out.println("Edad ingresada: " + edad);
        System.out.println("¿Es estudiante?: " + esEstudiante);
        System.out.println("Tarifa final:" + tarifa);
    }
}
