import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Entrenador entrenador1 = null; // Inicialmente nulos
        Entrenador entrenador2 = null; // Inicialmente nulos
        int opcion;

        // Introducción al juego
        System.out.println("===============================================");
        System.out.println("¡Bienvenido al Mundo Pokémon!");
        System.out.println("Aquí comienza tu aventura como Entrenador Pokémon.");
        System.out.println("Prepárate para demostrar tus habilidades y formar el mejor equipo.");
        System.out.println("¡Atrévete a ser el mejor como nadie lo fue!");

        do {
            System.out.println("\nMenu principal:"); // Menú principal del juego
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Mostrar Entrenador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Crear los entrenadores
                    System.out.print("\nIngresa el nombre del primer entrenador: ");
                    String nombre1 = entrada.nextLine();
                    entrenador1 = new Entrenador(nombre1); // Inicializar el primer entrenador

                    System.out.print("\nIngresa el nombre del segundo entrenador: ");
                    String nombre2 = entrada.nextLine();
                    entrenador2 = new Entrenador(nombre2); // Inicializar el segundo entrenador
                    break;

                case 2:
                    // Mostrar los nombres de los entrenadores
                    if (entrenador1 != null && entrenador2 != null) {
                        System.out.println("\nEntrenador 1: " + entrenador1.getNombre());
                        System.out.println("Entrenador 2: " + entrenador2.getNombre());
                    } else { // Si no se han creado los entrenadores
                        System.out.print("\nPrimero debes crear los entrenadores.");
                    }
                    break;

                case 3:
                    // Terminar el juego
                    System.out.println("¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println(); // Espacio entre iteraciones del menú
        } while (opcion != 3);

        entrada.close();
    }
}
