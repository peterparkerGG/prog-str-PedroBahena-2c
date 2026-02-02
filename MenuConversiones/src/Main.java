import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double resultado=0;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        do {
            System.out.println("MENÚ DE CONVERSIONES");
            System.out.println("1.°C a °F");
            System.out.println("2.°F a °C");
            System.out.println("3.Km a Millas");
            System.out.println("4.Millas a Km");
            System.out.println("5.Salir");
            System.out.print("Eliga una opción:");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= 4) {
                    double valor = 0;
                    boolean valorValido = false;

                    while (!valorValido) {
                        System.out.print("Ingrese el valor que desea convertir:");
                        if (sc.hasNextDouble()) {
                            valor = sc.nextDouble();
                            valorValido = true;
                        } else {
                            System.out.println("Ingrese un dato numerico.");
                            sc.next();
                        }
                    }

                    switch (opcion) {
                        case 1:
                            resultado = (valor * 9 / 5) + 32;
                            System.out.println(valor + " °C son " + resultado + " °F");
                            c1++;
                            break;
                        case 2:
                            resultado = (valor - 32) * 5 / 9;
                            System.out.println(valor + " grados Fahrenheit son " + resultado + " grados Celsius");
                            c2++;
                            break;
                        case 3:
                            resultado = valor * 0.621371;
                            System.out.println(valor + " km son " + resultado + " millas");
                            c3++;
                            break;
                        case 4:
                            resultado = valor / 0.621371;
                            System.out.println(valor + " millas son " + resultado + " km");
                            c4++;
                            break;
                    }
                } else if (opcion != 5) {
                    System.out.println("Opcion invalida (rango 1-5)");
                }
            } else {
                System.out.println("Debe usar solo numeros.");
                sc.next();
                opcion = 0;
            }

        } while (opcion != 5);
        int total = c1 + c2 + c3 + c4;
        System.out.println("RESUMEN");
        System.out.println("°C a °F:" + c1);
        System.out.println("°F a °C:" + c2);
        System.out.println("Km a Millas:" + c3);
        System.out.println("Millas a Km:" + c4);
        System.out.println("Total de conversiones:" + total);
        System.out.println("Se acabo el programa");
    }
}