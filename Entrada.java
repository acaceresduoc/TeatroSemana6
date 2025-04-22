public class Entrada {
    private int numeroAsiento;
    private double precio;
    private String ubicacion;
    private Cliente cliente;

    public Entrada(int numeroAsiento, String ubicacion, Cliente cliente) {
        this.numeroAsiento = numeroAsiento;
        this.precio = 50.0; // Precio base
        this.ubicacion = ubicacion;
        this.cliente = cliente;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double calcularPrecioConDescuento() {
        double descuento = 0.0;
        if (cliente.esEstudiante()) {
            descuento = 0.10; // 10% de descuento
        } else if (cliente.esTerceraEdad()) {
            descuento = 0.15; // 15% de descuento
        }
        return precio - (precio * descuento);
    }

    @Override
    public String toString() {
        return "Asiento: " + numeroAsiento + ", Precio: $" + precio + ", Ubicación: " + ubicacion + ", Cliente: " + cliente;
    }
}
