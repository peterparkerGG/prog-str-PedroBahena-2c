import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Ingrese nombre del alumno:");
        double p1 = leerDoubleEnRango(sc, "Calificacion del parcial 1:", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Calificacion del parcial 2:", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Calificacion del parcial 3:", 0, 100);
        int asistencia = leerIntEnRango(sc, "Ingrese la asistencia:", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "Entrego el proyecto? (true/false):");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double notaFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(notaFinal, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, notaFinal, estado);
    }


    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("Ingrese un número valido");
                sc.next();
            }
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número entero");
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Ingrese: true o false");
        }
    }

    public static void imprimirReporte(String nom, double p1, double p2, double p3,
                                       double prom, int asis, boolean proj, double fin, String est) {
        System.out.println("\n========================================");
        System.out.println("           REPORTE           ");
        System.out.println("Nombre: " + nom);
        System.out.println("Calificaciones de parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio de parciales: " + prom);
        System.out.println("Asistencia: " + asis);
        System.out.println("Entrego proyecto: " + proj);
        System.out.println("Calificacion final: " + fin);
        System.out.println("Estado: " + est);
        System.out.println("========================================");
    }
}
