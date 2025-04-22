import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private String nombreTeatro;
    private int capacidadSala;
    private int entradasDisponibles;
    private double precioUnitario;

    private static int totalEntradasVendidas = 0;
    private static double totalIngresos = 0.0;
    private static int totalReservas = 0;

    private List<Entrada> entradasVendidas;

    public Teatro(String nombreTeatro, int capacidadSala, double precioUnitario) {
        this.nombreTeatro = nombreTeatro;
        this.capacidadSala = capacidadSala;
        this.entradasDisponibles = capacidadSala;
        this.precioUnitario = precioUnitario;
        this.entradasVendidas = new ArrayList<>();
    }

    public boolean reservarEntrada() {
        if (entradasDisponibles <= 0) {
            System.out.println("No hay entradas disponibles para reservar.");
            return false;
        }
        totalReservas++;
        entradasDisponibles--;
        return true;
    }

    public boolean venderEntrada(Entrada entrada) {
        if (entradasDisponibles <= 0) {
            System.out.println("No hay entradas disponibles para vender.");
            return false;
        }
        entradasVendidas.add(entrada);
        totalEntradasVendidas++;
        totalIngresos += entrada.calcularPrecioConDescuento();
        entradasDisponibles--;
        return true;
    }

    public Entrada buscarEntradaPorAsiento(int numeroAsiento) {
        for (Entrada entrada : entradasVendidas) {
            if (entrada.getNumeroAsiento() == numeroAsiento) {
                return entrada;
            }
        }
        return null;
    }

    public boolean modificarAsiento(int asientoActual, int nuevoAsiento) {
        Entrada entrada = buscarEntradaPorAsiento(asientoActual);
        if (entrada != null) {
            entrada.setNumeroAsiento(nuevoAsiento);
            return true;
        }
        return false;
    }

    public static int getTotalEntradasVendidas() {
        return totalEntradasVendidas;
    }

    public static double getTotalIngresos() {
        return totalIngresos;
    }

    public static int getTotalReservas() {
        return totalReservas;
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }
}
