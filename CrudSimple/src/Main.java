import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PersonaService service = new PersonaService();
        Validator input = new Validator();
        Persona[] personas = new Persona[20];

        int opc;
        do {
            System.out.println("MENU");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");
            opc = input.getIntNumber(sc, "Opcion:");

            switch (opc) {
                case 1:
                    service.alta(sc, personas);
                    break;
                case 2:
                    service.buscarId(sc, personas);
                    break;
                case 3:
                    service.bajalogica(sc, personas);
                    break;
                case 4:
                    service.listaActiva(personas);
                    break;
                case 5:
                    service.actualizarNombre(sc, personas);
                    break;
                case 0:
                    System.out.println("Salio del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opc != 0);
    }
}