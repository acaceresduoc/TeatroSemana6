import java.util.ArrayList;
import java.util.List;

public class SistemaDeVentas {
    private List<Entrada> entradasVendidas = new ArrayList<>();
    private static int totalEntradasVendidas = 0;
    private static double totalIngresos = 0.0;

    public void agregarEntrada(Entrada entrada) {
        entradasVendidas.add(entrada);
    }

    public void venderEntrada(Cliente cliente, Entrada entrada) {
        double precioFinal = entrada.getPrecio();

        if (cliente.esEstudiante()) {
            precioFinal *= 0.90;
        } else if (cliente.esTerceraEdad()) {
            precioFinal *= 0.85;
        }

        entrada.setPrecio(precioFinal);
        entradasVendidas.add(entrada);
        totalEntradasVendidas++;
        totalIngresos += precioFinal;

        System.out.println("Entrada vendida a " + cliente + " por $" + precioFinal);
    }

    public void buscarEntrada(String criterio) {
        boolean encontrada = false;

        for (int i = 0; i < entradasVendidas.size(); i++) {
            Entrada entrada = entradasVendidas.get(i);

            if (criterio.matches("\\d+") && Integer.parseInt(criterio) == i) {
                System.out.println("Entrada encontrada: Número: " + i + ", Precio: $" + entrada.getPrecio());
                encontrada = true;
            } else if (entrada.getUbicacion().equalsIgnoreCase(criterio)) {
                System.out.println("Entrada encontrada: Número: " + i + ", Ubicación: " + entrada.getUbicacion() + ", Precio: $" + entrada.getPrecio());
                encontrada = true;
            } else if (criterio.equalsIgnoreCase("estudiante") && entrada.getCliente().esEstudiante()) {
                System.out.println("Entrada encontrada: Número: " + i + ", Cliente: " + entrada.getCliente() + ", Precio: $" + entrada.getPrecio());
                encontrada = true;
            } else if (criterio.equalsIgnoreCase("tercera edad") && entrada.getCliente().esTerceraEdad()) {
                System.out.println("Entrada encontrada: Número: " + i + ", Cliente: " + entrada.getCliente() + ", Precio: $" + entrada.getPrecio());
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron entradas con el criterio especificado.");
        }
    }

    public void eliminarEntrada(int numero) {
        if (numero >= 0 && numero < entradasVendidas.size()) {
            Entrada entradaEliminada = entradasVendidas.remove(numero);
            System.out.println("Entrada eliminada: " + entradaEliminada);
        } else {
            System.out.println("Número de entrada no válido.");
        }
    }

    public static int getTotalEntradasVendidas() {
        return totalEntradasVendidas;
    }

    public static double getTotalIngresos() {
        return totalIngresos;
    }
}
