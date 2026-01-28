import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int opc;
        double num1, num2, res;

        System.out.println("BIENVENIDO A LA CALCULADORA");
        System.out.println("Menu");
        System.out.println("1.Sumar");
        System.out.println("2.Restar");
        System.out.println("3.Multiplicar");
        System.out.println("4.Dividir");
        System.out.print("Elija una opcion: ");
        opc = leer.nextInt();
        switch (opc){
            case 1:
                System.out.print("Ingrese el numero 1: ");
                num1 = leer.nextDouble();
                System.out.print("Ingrese el numero 2: ");
                num2 = leer.nextDouble();
                res = num1 + num2;
                System.out.println("Suma");
                System.out.println(num1 + " + " + num2 + " = " + res);
                break;

            case 2:
                System.out.print("Ingrese el numero 1: ");
                num1 = leer.nextDouble();
                System.out.print("Ingrese el numero 2: ");
                num2 = leer.nextDouble();
                res = num1 - num2;
                System.out.println("Resta");
                System.out.println(num1 + " - " + num2 + " = " + res);
                break;

            case 3:
                System.out.print("Ingrese el numero 1: ");
                num1 = leer.nextDouble();
                System.out.print("Ingrese el numero 2: ");
                num2 = leer.nextDouble();
                res = num1 * num2;
                System.out.println("Multiplicacion");
                System.out.println(num1 + " x " + num2 + " = " + res);
                break;

            case 4:
                System.out.print("Ingrese el numero 1: ");
                num1 = leer.nextDouble();
                System.out.print("Ingrese el numero 2: ");
                num2 = leer.nextDouble();
                System.out.println("Division");
                if (num2 == 0) {
                    System.out.println("No se puede dividir entre cero.");
                } else {
                    res = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + res);
                }
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
}