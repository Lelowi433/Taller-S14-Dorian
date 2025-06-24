import java.util.HashMap;
import java.util.Map;

public class InventarioCartas {
    private static final int LIMITE_POR_CARTA = 2;
    private Map<Carta, Integer> inventario;

    public InventarioCartas() {
        inventario = new HashMap<>();
    }

    public void agregarCarta(Carta carta) throws Exception {
        int cantidadActual = inventario.getOrDefault(carta, 0);
        if (cantidadActual >= LIMITE_POR_CARTA) {
            throw new Exception("No se pueden tener más de " + LIMITE_POR_CARTA + " copias de esta carta.");
        }
        inventario.put(carta, cantidadActual + 1);
        System.out.println("Carta agregada: " + carta.getNombre());
    }

    public void eliminarCarta(Carta carta) throws Exception {
        if (!inventario.containsKey(carta)) {
            throw new Exception("La carta no existe en el inventario.");
        }

        int cantidadActual = inventario.get(carta);
        if (cantidadActual == 1) {
            inventario.remove(carta);
        } else {
            inventario.put(carta, cantidadActual - 1);
        }
        System.out.println("Carta eliminada: " + carta.getNombre());
    }

    public void listarCartas() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("Cartas en el inventario:");
        for (Map.Entry<Carta, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }
}
