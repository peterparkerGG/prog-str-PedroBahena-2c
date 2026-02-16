import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] lista = new Alumno[25];
        AlumnoService service = new AlumnoService();
        int opc = -1;

        while (opc != 0) {
            System.out.println("MENU");
            System.out.println("1.-Alta alumno");
            System.out.println("2.-Buscar por ID");
            System.out.println("3.-Actualizar promedio");
            System.out.println("4.-Baja logica");
            System.out.println("5.-Listar activos");
            System.out.println("6-.Reportes");
            System.out.println("0.-Salir");
            System.out.print("Opcion:");

            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                continue;
            }

            if (opc == 1) {
                System.out.print("Ingrese ID:");
                int id = Integer.parseInt(sc.nextLine());
                if (service.validarId(lista, id)) {
                    System.out.print("Ingrese nombre:");
                    String nom = sc.nextLine();
                    System.out.print("Ingrese promedio:");
                    double pr = Double.parseDouble(sc.nextLine());
                    if (pr >= 0 && pr <= 10 && !nom.isEmpty()) {
                        service.registrar(lista, id, nom, pr);
                    } else {
                        System.out.println("El dato no es valido");
                    }
                } else {
                    System.out.println("ID repetido o invalido");
                }

            } else if (opc == 2) {
                System.out.print("ID a buscar:");
                service.buscar(lista, Integer.parseInt(sc.nextLine()));

            } else if (opc == 3) {
                System.out.print("ID para actualizar:");
                int idAct = Integer.parseInt(sc.nextLine());
                System.out.print("Nuevo promedio:");
                double np = Double.parseDouble(sc.nextLine());
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i] != null && lista[i].id == idAct && lista[i].activo) {
                        lista[i].promedio = np;
                        System.out.println("Actualizado con exito");
                    }
                }

            } else if (opc == 4) {
                System.out.print("ID para dar de baja:");
                service.darBaja(lista, Integer.parseInt(sc.nextLine()));

            } else if (opc == 5) {
                service.listarActivos(lista);

            } else if (opc == 6) {
                service.mostrarReportes(lista);

            } else if (opc == 0) {
                System.out.println("Saliendo del programa");
            }
        }
    }
}