import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- MENÚ ---");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa tu peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu altura (m): ");
                    double altura = scanner.nextDouble();
                    System.out.println("Tu IMC es: " + calcularIMC(peso, altura));
                    break;
                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura: ");
                    double altRect = scanner.nextDouble();
                    System.out.println("El área es: " + calcularAreaRectangulo(base, altRect));
                    break;
                case 3:
                    System.out.print("Ingresa grados Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Convertidos a Fahrenheit: " + convertirCelsiusAFahrenheit(celsius));
                    break;
                case 4:
                    System.out.print("Ingresa el radio: ");
                    double radio = scanner.nextDouble();
                    System.out.println("El área del círculo es: " + calcularAreaCirculo(radio));
                    break;
                case 5:
                    System.out.println("Saliste del programa, vuelve pronto:)");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
            System.out.println();
        } while (opcion != 5);
    }

    /**
     * Calcula el IMC basado en el peso y la altura
     * @param peso
     * @param altura
     * @return El valor calculado del IMC
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo multiplicando base por altura
     * @param base
     * @param altura
     * @return El área total del rectángulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte grados Celsius a Fahrenheit
     * @param celsius
     * @return La temperatura equivalente en grados Fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo utilizando el radio proporcionado
     * @param radio
     * @return El área del círculo calculado
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}