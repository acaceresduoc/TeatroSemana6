public class Cliente {
    private String nombre;
    private boolean esEstudiante;
    private boolean esTerceraEdad;

    public Cliente(String nombre, boolean esEstudiante, boolean esTerceraEdad) {
        this.nombre = nombre;
        this.esEstudiante = esEstudiante;
        this.esTerceraEdad = esTerceraEdad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esEstudiante() {
        return esEstudiante;
    }

    public void setEsEstudiante(boolean esEstudiante) {
        this.esEstudiante = esEstudiante;
    }

    public boolean esTerceraEdad() {
        return esTerceraEdad;
    }

    public void setEsTerceraEdad(boolean esTerceraEdad) {
        this.esTerceraEdad = esTerceraEdad;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre +
                ", Estudiante: " + (esEstudiante ? "Sí" : "No") +
                ", Tercera Edad: " + (esTerceraEdad ? "Sí" : "No");
    }
}
