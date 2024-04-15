
package exp2_s6_rodrigo_sanchez;

import java.util.Scanner;

public class EXP2_S6_Rodrigo_Sanchez {

    private static final String nombreTeatro = "Teatro Moro";
    private static final int capacidadSala = 100;
    private static int entradasDisponibles = capacidadSala;
    private static final double precioEntrada = 5000;
    private static int totalEntradasVendidas = 0;
    private static double totalIngresos = 0; 
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Bienvenido al " + nombreTeatro + " ===");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Imprimir boleta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ventaEntradas(scanner);
                    break;
                case 2:
                    imprimirBoleta();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        }

        System.out.println("Gracias por utilizar el sistema de venta de entradas del " + nombreTeatro + ".");
    }

    public static void ventaEntradas(Scanner scanner) {
        System.out.println("=== Venta de Entradas ===");

        if (entradasDisponibles > 0) {
            System.out.print("Ingrese la ubicación de la entrada (VIP, Platea, General): ");
            String ubicacion = scanner.next();

            double precioFinal = precioEntrada;

            System.out.print("¿Es estudiante? (Sí / No): ");
            String esEstudiante = scanner.next();

            if (esEstudiante.equalsIgnoreCase("Sí")) {
                precioFinal *= 0.9; // Aplicar descuento del 10% para estudiantes
            } else {
                System.out.print("¿Es de la tercera edad? (Sí / No): ");
                String esTerceraEdad = scanner.next();

                if (esTerceraEdad.equalsIgnoreCase("Sí")) {
                    precioFinal *= 0.85; // Aplicar descuento del 15% para personas de la tercera edad
                }
            }

            System.out.println("Precio final de la entrada: $" + precioFinal);
            System.out.println("¡Entrada vendida! Disfrute del espectáculo en la ubicación: " + ubicacion);
            totalEntradasVendidas++;
            totalIngresos += precioFinal;
            entradasDisponibles--;
        } else {
            System.out.println("Lo sentimos, no hay entradas disponibles.");
        }
    }

    public static void imprimirBoleta() {
        if (totalEntradasVendidas > 0) {
            System.out.println("=== Boleta ===");
            System.out.println("Total de entradas vendidas: " + totalEntradasVendidas);
            System.out.println("Total de ingresos: $" + totalIngresos);
        } else {
            System.out.println("No se han vendido entradas aún.");
        }
    }
}