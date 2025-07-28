package Ejercicio1;

import java.util.HashMap;
import java.util.Scanner;

public class MainEstudiante {
    private static final HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> ingresarEstudiante();
                    case 2 -> verEstudiantes();
                    case 3 -> buscarEstudiante();
                    case 4 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("⚠️ Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Ingrese un número válido.");
                opcion = 0;
            }
            System.out.println("------------------------------------------");
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("======= MENÚ PRINCIPAL =======");
        System.out.println("1. Ingreso de estudiante");
        System.out.println("2. Ver estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Salir");
        System.out.println("==============================");
    }

    private static void ingresarEstudiante() {
        System.out.print("Ingrese el número de carnet: ");
        String carnet = scanner.nextLine();

        if (estudiantes.containsKey(carnet)) {
            System.out.println("⚠️ El carnet ya existe. No se puede duplicar.");
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        int edad = 0;
        while (true) {
            try {
                System.out.print("Ingrese la edad: ");
                edad = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Edad no válida. Intente nuevamente.");
            }
        }

        System.out.print("Ingrese la carrera: ");
        String carrera = scanner.nextLine();

        System.out.print("Ingrese la materia: ");
        String materia = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, edad, carrera, materia);
        estudiantes.put(carnet, estudiante);
        System.out.println("✅ Estudiante ingresado con éxito.");
    }

    private static void verEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("📭 No hay estudiantes registrados.");
        } else {
            System.out.println("📋 Lista de Estudiantes:");
            for (String carnet : estudiantes.keySet()) {
                System.out.println("------------------------------");
                System.out.println("Carnet: " + carnet);
                System.out.println(estudiantes.get(carnet));
            }
        }
    }

    private static void buscarEstudiante() {
        System.out.print("Ingrese el número de carnet a buscar: ");
        String carnet = scanner.nextLine();
        Estudiante estudiante = estudiantes.get(carnet);

        if (estudiante != null) {
            System.out.println("✅ Estudiante encontrado:");
            System.out.println(estudiante);
        } else {
            System.out.println("❌ Estudiante no encontrado.");
        }
    }
}
