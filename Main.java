import java.util.Scanner;

public class Main {
    private static Teatro teatro;

    public static void main(String[] args) {
        teatro = new Teatro("Teatro Moro", 100, 50.0);
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = Validador.validarOpcionMenu(scanner, 1, 5);

            switch (opcion) {
                case 1 -> reservarEntrada();
                case 2 -> comprarEntrada(scanner);
                case 3 -> modificarVenta(scanner);
                case 4 -> imprimirBoleta(scanner);
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Venta ---");
        System.out.println("1. Reservar entradas");
        System.out.println("2. Comprar entradas");
        System.out.println("3. Modificar una venta existente");
        System.out.println("4. Imprimir boleta");
        System.out.println("5. Salir");
    }

    private static void reservarEntrada() {
        if (teatro.getEntradasDisponibles() > 0) {
            if (teatro.reservarEntrada()) {
                System.out.println("Entrada reservada exitosamente.");
            } else {
                System.out.println("No se pudo reservar la entrada. Intente nuevamente.");
            }
        } else {
            System.out.println("No hay entradas disponibles para reservar.");
        }
    }

    private static int numeroAsiento = 1; // Contador para asignar asientos

    private static void comprarEntrada(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        boolean esEstudiante = false;
        while (true) {
            System.out.print("¿Es estudiante? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                esEstudiante = true;
                break;
            } else if (respuesta.equals("no")) {
                esEstudiante = false;
                break;
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
            }
        }

        boolean esTerceraEdad = false;
        while (true) {
            System.out.print("¿Es de tercera edad? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                esTerceraEdad = true;
                break;
            } else if (respuesta.equals("no")) {
                esTerceraEdad = false;
                break;
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
            }
        }

        Cliente cliente = new Cliente(nombre, esEstudiante, esTerceraEdad);
        Entrada entrada = new Entrada(numeroAsiento, "General", cliente); // Asignar el número de asiento

        if (teatro.venderEntrada(entrada)) {
            System.out.println("Entrada comprada exitosamente. Asiento asignado: " + numeroAsiento);
            numeroAsiento++; // Incrementar el número de asiento para la próxima venta
        }
    }

    private static void modificarVenta(Scanner scanner) {
        System.out.print("Ingrese el número del asiento a modificar: ");
        int asientoActual = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el nuevo número de asiento: ");
        int nuevoAsiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (teatro.modificarAsiento(asientoActual, nuevoAsiento)) {
            System.out.println("Asiento modificado exitosamente.");
        } else {
            System.out.println("No se encontró una entrada con el asiento especificado.");
        }
    }

    private static void imprimirBoleta(Scanner scanner) {
        System.out.print("Ingrese el número del asiento para generar la boleta: ");
        int asiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Entrada entrada = teatro.buscarEntradaPorAsiento(asiento);
        if (entrada != null) {
            System.out.println("\n--- Boleta ---");
            System.out.println(entrada);
        } else {
            System.out.println("No se encontró una entrada con el asiento especificado.");
        }
    }
}
