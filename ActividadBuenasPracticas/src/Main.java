import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa un numero:");
        int num1 = leer.nextInt();
        int resultado = sumadenumeros(num1);
        System.out.println(mensaje() + ":" + resultado);
    }
    public static int sumadenumeros(int num1) {
        int acumulador = 0;
        for (int i = 1; i <= num1; i++) {
            acumulador += i;
        }
        return acumulador;
    }
    public static String mensaje() {
        return "La suma total es de: ";
    }
}