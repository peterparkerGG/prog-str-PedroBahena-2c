import java.util.Scanner;

public class PersonaService {

    public void alta(Scanner sc, Persona[] personas) {
        Validator input = new Validator();
        int id = input.getIntNumber(sc, "Ingrese su ID:");
        if (id <= 0) {
            System.out.println("No debe ser cero");
            return;
        }
        if (existeId(personas, id)) {
            System.out.println("ID existente");
            return;
        }
        System.out.print("Ingresa tu nombre:");
        String name = sc.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Nombre no valido");
            return;
        }
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, name);
                System.out.println("Alta exitosa");
                return;
            }
        }
        System.out.println("No hay espacio disponible");
    }
    public void buscarId(Scanner sc, Persona[] personas) {
        Validator input = new Validator();
        int id = input.getIntNumber(sc, "Ingresa el ID que buscas: ");
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isSctive()) {
                System.out.println(persona);
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva");
    }
    public void bajalogica(Scanner sc, Persona[] personas) {

        Validator input = new Validator();
        int id = input.getIntNumber(sc, "Ingresa el ID a dar de baja: ");
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isSctive()) {
                persona.setSctive(false);
                System.out.println("Baja logica realizada");
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva");
    }
    public void listaActiva(Persona[] personas) {
        boolean hay = false;
        for (Persona persona : personas) {
            if (persona != null && persona.isSctive()) {
                System.out.println(persona);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }
    public void actualizarNombre(Scanner sc, Persona[] personas) {
        Validator input = new Validator();
        int id = input.getIntNumber(sc, "Ingresa el ID:");
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isSctive()) {
                System.out.print("Ingrese el nuevo nombre:");
                String nuevoNombre = sc.nextLine();

                if (nuevoNombre.trim().isEmpty()) {
                    System.out.println("Nombre no valido");
                    return;
                }

                persona.setName(nuevoNombre);
                System.out.println("Nombre actualizado");
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva");
    }
    private boolean existeId(Persona[] personas, int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return true;
            }
        }
        return false;
    }
}