import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputValueValidator inputValidator = new InputValueValidator();
        ShippingCalculator shippingCalculator = new ShippingCalculator();

        double pesoKg = inputValidator.leerDoubleEnRango("Ingrese el peso en kg:", sc, 0.1, 50.0);
        int distanciaKm = inputValidator.leerIntEnRango("Ingrese la distancia en km:", sc, 1, 2000);
        int tipoServicio = inputValidator.leerIntEnRango("Ingrese el tipo de servicio (1=estandar, 2=express)", sc, 1, 2);
        boolean esZonaRemota = inputValidator.leerBoolean("El destino es una zona remota?", sc);


        double subtotal = shippingCalculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = shippingCalculator.calcularIVA(subtotal);
        double total = shippingCalculator.calcularTotal(subtotal, iva);


        imprimirTicket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total);
    }


    public static void imprimirTicket(int serv, double p, int d, boolean r, double sub, double iva, double tot) {

        System.out.println("TICKET DE ENVIO");
        if (serv == 1) {
            System.out.println("Tipo de servicio: estandar");
        } else {
            System.out.println("Tipo de servicio: express");
        }

        System.out.println("Peso ingresado: " + p + " kg");
        System.out.println("Distancia total: " + d + " km");

        if (r == true) {
            System.out.println("La zona es remota?: si");
        } else {
            System.out.println("La zona es remota?: no");
        }

        System.out.println("-------------------------------------------");
        System.out.println("Subtotal sin impuestos:$" + sub);
        System.out.println("IVA:$" + iva);
        System.out.println("Precio total a pagar:$" + tot);
        System.out.println("-------------------------------------------");
    }
}