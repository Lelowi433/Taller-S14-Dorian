public class Carta {
    private String nombre;
    private String tipo; // Ej: Mago, Guerrero, Hechizo, etc.

    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Carta:\n" +
                "nombre: " + nombre + "\n" +
                "tipo: " + tipo + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Carta)) return false;
        Carta otra = (Carta) obj;
        return nombre.equalsIgnoreCase(otra.nombre) && tipo.equalsIgnoreCase(otra.tipo);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode() + tipo.toLowerCase().hashCode();
    }
}
