import java.util.Scanner;

public class Validador {
    public static String validarOpcionSiNo(Scanner scanner, String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje + " (Si/No): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si") || respuesta.equals("no")) {
                return respuesta;
            }
            System.out.println("Entrada no válida. Por favor, ingrese 'Si' o 'No'.");
        }
    }

    public static int validarOpcionMenu(Scanner scanner, int min, int max) {
        int opcion;
        while (true) {
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
            } else {
                scanner.nextLine(); // Limpiar el buffer
            }
            System.out.println("Opción no válida. Por favor, ingrese un número entre " + min + " y " + max + ".");
        }
    }

    public static String validarUbicacionEntrada(Scanner scanner, String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje + " (VIP, Platea, General): ");
            respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("VIP") || respuesta.equalsIgnoreCase("Platea") || respuesta.equalsIgnoreCase("General")) {
                return respuesta;
            }
            System.out.println("Entrada no válida. Por favor, ingrese 'VIP', 'Platea' o 'General'.");
        }
    }
}
