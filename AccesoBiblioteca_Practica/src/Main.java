import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String codigo_user, entrada = "";

        // Contadores para el resumen final
        int totalValidos = 0;
        int permitidos = 0;
        int denegados = 0;

        while (!entrada.equalsIgnoreCase("SALIR")) {
            System.out.println("--- Nuevo Registro ---");
            entrada = sc.nextLine();
            if(entrada.equalsIgnoreCase("SALIR")) break;

            // 4) Validación de Código [cite: 4]
            System.out.println("Ingrese el Código (6 caracteres alfanuméricos):");
            codigo_user = sc.nextLine();
            if (!esCodigoValido(codigo_user)) {
                System.out.println("Código inválido");
                continue;
            }
            totalValidos++; // Pasó la validación de código

            // 5) Validación Tipo de Usuario [cite: 5]
            System.out.println("¿Es alumno? (true/false):");
            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                return;
            }
            boolean esAlumno = sc.nextBoolean();

            // 6) Validación Hora [cite: 6]
            System.out.println("Ingrese la Hora (0-23):");
            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                return;
            }
            int hora = sc.nextInt();
            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida");
                return;
            }

            // 8) Regla de Biblioteca Cerrada
            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break; // Termina el ciclo
            }

            // 7) Regla de Horario Permitido [cite: 7]
            if (esHorarioPermitido(hora, esAlumno)) {
                System.out.println("Acceso PERMITIDO");
                permitidos++;
            } else {
                System.out.println("Acceso DENEGADO");
                denegados++;
            }

            // Limpiar buffer y preguntar si desea seguir
            sc.nextLine();
            System.out.println("¿Desea realizar otro registro? (Presione Enter o escriba 'SALIR')");
            entrada = sc.nextLine();
        }

        // 9) Salida de resultados
        System.out.println("\n========== RESUMEN FINAL ==========");
        System.out.println("Total de registros con código válido: " + totalValidos);
        System.out.println("Total permitidos: " + permitidos);
        System.out.println("Total denegados: " + denegados);

        if (totalValidos > 0) {
            double porcentaje = (double) permitidos / (permitidos + denegados) * 100;
            System.out.printf("Porcentaje de permitidos: %.2f%%\n", porcentaje);
        }

        sc.close();
    }

    // 10) Método estático para validar código [cite: 10]
    public static boolean esCodigoValido(String codigo) {
        if (codigo == null || codigo.isBlank() || codigo.length() != 6) {
            return false;
        }
        return codigo.matches("^[a-zA-Z0-9]*$");
    }

    // 11) Método estático para validar horario [cite: 11]
    public static boolean esHorarioPermitido(int hora, boolean esAlumno) {
        if (esAlumno) {
            return hora >= 8 && hora <= 20; // Alumnos: 8..20 [cite: 7]
        } else {
            return hora >= 10 && hora <= 18; // Externos: 10..18 [cite: 7]
        }
    }
}