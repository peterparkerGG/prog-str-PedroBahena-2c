public class AlumnoService {

    public void registrar(Alumno[] lista, int id, String nom, double prom) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new Alumno(id, nom, prom);
                System.out.println("Alumno registrado");
                return;
            }
        }
        System.out.println("No hay espacio");
    }

    public boolean validarId(Alumno[] lista, int id) {
        if (id <= 0) return false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].id == id) return false;
        }
        return true;
    }

    public void buscar(Alumno[] lista, int id) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].id == id && lista[i].activo) {
                System.out.println("ID: " + lista[i].id + " |" + " Nombre: " + lista[i].nombre + " |" + " Promedio: " + lista[i].promedio);
                return;
            }
        }
        System.out.println("No se encontro");
    }

    public void darBaja(Alumno[] lista, int id) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].id == id && lista[i].activo) {
                lista[i].activo = false;
                System.out.println("Baja realizada con exito");
                return;
            }
        }
        System.out.println("ID no encontrado");
    }

    public void listarActivos(Alumno[] lista) {
        boolean hay = false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].activo) {
                System.out.println("ID: " + lista[i].id + " |" + " Nombre: " + lista[i].nombre + " |" + " Promedio: " + lista[i].promedio);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay alumnos activos");
    }

    public void mostrarReportes(Alumno[] lista) {
        double suma = 0;
        int conta = 0, masOcho = 0;
        Alumno mejor = null, peor = null;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].activo) {
                suma += lista[i].promedio;
                conta++;
                if (lista[i].promedio >= 8.0) masOcho++;

                if (mejor == null || lista[i].promedio > mejor.promedio) mejor = lista[i];
                if (peor == null || lista[i].promedio < peor.promedio) peor = lista[i];
            }
        }

        if (conta > 0) {
            System.out.println("Promedio general: " + (suma / conta));
            // Agregado el ID en las siguientes dos lineas
            System.out.println("Mayor promedio: ID " + mejor.id + " " + mejor.nombre + " con " + mejor.promedio);
            System.out.println("Menor promedio: ID " + peor.id + " " + peor.nombre + " con " + peor.promedio);
            System.out.println("Alumnos con 8 o mas: " + masOcho);
        } else {
            System.out.println("No hay datos");
        }
    }
}