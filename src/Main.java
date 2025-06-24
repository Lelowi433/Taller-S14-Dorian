import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarioCartas inventario = new InventarioCartas();

        System.out.println("Bienvenido al Inventario de Cartas Hearthstone");

        while (true) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Agregar carta");
            System.out.println("2. Eliminar carta");
            System.out.println("3. Listar cartas");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre de la carta: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Tipo de la carta: ");
                        String tipo = scanner.nextLine();
                        Carta nueva = new Carta(nombre, tipo);
                        try {
                            inventario.agregarCarta(nueva);
                        } catch (Exception e) {
                            System.out.println("Por favor coloque una opción válida: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.print("Nombre de la carta a eliminar: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Tipo de la carta: ");
                        String tipo = scanner.nextLine();
                        Carta aEliminar = new Carta(nombre, tipo);
                        try {
                            inventario.eliminarCarta(aEliminar);
                        } catch (Exception e) {
                            System.out.println("Error, por favor ponga una opción válida: " + e.getMessage());
                        }
                    }
                    case 3 -> inventario.listarCartas();
                    case 4 -> {
                        System.out.println("Gracias por usar el inventario!");
                        return; // para salir del main y del loop
                    }
                    default -> System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingresa un número.");
            }
        }
    }
}
