import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public final Random random = new Random();
    private static ArrayList<Tareas> tareas = new ArrayList<>();
    private static AgendaDao agendaDAO = new AgendaDao();

    public static void main(String[] args) {
        int Opcion;
        do {
            System.out.println("Elija una opcion por ");
            System.out.println("1 PAR O IMPAR");
            System.out.println("2 Primo o no Primo");
            System.out.println("3 Adivinanza");
            System.out.println("4 Lista de Tareas");
            System.out.println("5 Conversor de Temperaturas");
            System.out.println("6 CRUD Agenda (Base de Datos)");
            System.out.println("0 Salir del Programa");
            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    ParImpar();
                    break;
                case 2:
                    NumerosPrimos();
                    break;
                case 3:
                    Adivinanza();
                    break;
                case 4:
                    menuTareas();
                    break;
                case 5:
                    Temperatura();
                    break;
                case 6:
                    menuAgenda();
                    break;
                case 0:
                    System.out.println("Gracias, Adios");
                    break;
                default:
                    System.out.println("Ingrese un numero Valido de entre 1 - 6");
                    break;
            }
        } while (Opcion != 0);
    }

    // -------------------- OPCIÓN 1 --------------------
    public static void ParImpar() {
        System.out.println("Ingrese un numero para determinar si es par o no ");
        int A = sc.nextInt();

        if (A % 2 == 0) {
            System.out.println("Su numero es Par");
        } else if (A % 2 == 1) {
            System.out.println("Su numero es Impar");
        } else {
            System.out.println("Su numero es invalido");
        }
    }

    // -------------------- OPCIÓN 2 --------------------
    public static void NumerosPrimos() {
        System.out.println("Ingrese un numero para determinar si es primo o no ");
        boolean primo = true;
        int A = sc.nextInt();

        if (A <= 1) {
            primo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(A); i++)
                if (A % i == 0) {
                    primo = false;
                    break;
                }
        }

        if (primo) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }

    // -------------------- OPCIÓN 3 --------------------
    public static void Adivinanza() {
        Random random = new Random();
        int A = random.nextInt(10) + 1; // entre 1 y 10
        System.out.println("Elije un numero entre el 1 y 10, a ver si adivinas el que estoy pensando:");
        int B = sc.nextInt();

        if (A == B) {
            System.out.println("¡Has adivinado! Tu número: " + B + " | Mi número: " + A);
        } else {
            System.out.println("Opss, no es el numero. El que estaba pensando era " + A);
        }
    }

    // -------------------- OPCIÓN 4 --------------------
    public static void menuTareas() {
        int opcion;
        do {
            System.out.println("\n--- MENU DE TAREAS ---");
            System.out.println("1. Ingresar Tarea");
            System.out.println("2. Buscar Tarea");
            System.out.println("3. Modificar Tarea");
            System.out.println("4. Listar Tareas");
            System.out.println("5. Salir");
            System.out.print("Escoga una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarTarea();
                    break;
                case 2:
                    buscarTarea();
                    break;
                case 3:
                    modificarTarea();
                    break;
                case 4:
                    listarTareas();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opcion Invalida. Intente de nuevo");
            }
        } while (opcion != 5);
    }

    private static void ingresarTarea() {
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese el nombre de la Tarea: ");
        String nombreTarea = sc.nextLine();
        System.out.print("Ingrese la descripcion de la Tarea: ");
        String descripcion = sc.nextLine();

        Tareas nuevaTarea = new Tareas(nombreTarea, descripcion);
        tareas.add(nuevaTarea);
        System.out.println("Tarea agregada con éxito. Código: " + nuevaTarea.getCodigoTarea());
    }

    private static void buscarTarea() {
        System.out.print("Ingrese el código de la tarea: ");
        int codigo = sc.nextInt();

        for (Tareas tareita : tareas) {
            if (tareita.getCodigoTarea() == codigo) {
                System.out.println(tareita);
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    private static void modificarTarea() {
        System.out.print("Ingrese el código de la tarea a modificar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (Tareas tareita : tareas) {
            if (tareita.getCodigoTarea() == codigo) {
                System.out.print("Ingrese el nuevo nombre de la Tarea: ");
                tareita.setNombreTarea(sc.nextLine());
                System.out.print("Ingrese la nueva descripcion de la Tarea: ");
                tareita.setDescripcion(sc.nextLine());
                System.out.println("Datos de la Tarea modificados con éxito.");
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    private static void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        for (Tareas tareita : tareas) {
            System.out.println(tareita);
        }
    }

    // -------------------- OPCIÓN 5 --------------------
    public static void Temperatura() {
        System.out.println("Ingrese los grados en Fahrenheit:");
        double F = sc.nextDouble();
        double C = (F - 32) * 5 / 9;
        System.out.println("Temperatura en Celsius: " + C);
    }

    // -------------------- OPCIÓN 6 (CRUD AGENDA) --------------------
    public static void menuAgenda() {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD AGENDA ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar por código");
            System.out.println("4. Modificar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    listarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    modificarContacto();
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void agregarContacto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        agendaDAO.insertar(new Agenda(nombre, apellido, telefono, descripcion));
    }

    private static void listarContactos() {
        List<Agenda> lista = agendaDAO.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            for (Agenda a : lista) {
                System.out.println(a.getCodigo() + " - " + a.getNombre() + " " + a.getApellido() + " - " + a.getTelefono());
            }
        }
    }

    private static void buscarContacto() {
        System.out.print("Código a buscar: ");
        int codigo = sc.nextInt();
        agendaDAO.buscar(codigo);
    }

    private static void modificarContacto() {
        System.out.print("Código a modificar: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();
        agendaDAO.actualizar(new Agenda(codigo, nombre, apellido, telefono, descripcion));
    }

    private static void eliminarContacto() {
        System.out.print("Código a eliminar: ");
        int codigo = sc.nextInt();
        agendaDAO.eliminar(codigo);
    }
}
