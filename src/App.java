import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Entrenador[] entrenadores = new Entrenador[2]; // Arreglo de objetos Entrenador
        int opcion;

        //Introcucción al juego
        System.out.println("===============================================");
        System.out.println("¡Bienvenido al Mundo Pokémon!");
        System.out.println("Aquí comienza tu aventura como Entrenador Pokémon.");
        System.out.println("Prepárate para demostrar tus habilidades y formar el mejor equipo.");
        System.out.println("¡Atrévete a ser el mejor como nadie lo fue!");

        do {
            System.out.println("\nMenu principal:");  //Crear el menu principal del juego
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Mostrar Entrenador");
            System.out.println("3. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    // Solicitar los nombres de los entrenadores
                    for (int i = 0; i < 2; i++) {
                        System.out.println("\nIngrese el nombre del entrenador " + (i + 1) + ": ");
                        String nombre = entrada.nextLine();
                        entrenadores[i] = new Entrenador(nombre, new String[3]); // Crear un objeto Entrenador
                    }
                    break;
                case 2:
                    // Imprimir los nombres de los entrenadores
                    for (int i = 0; i < 2; i++) {
                        System.out.println("\nEl nombre del entrenador " + (i + 1) + " es: " + entrenadores[i].getNombre());
                    }
                    break;
                case 3:
                    //Terminar el juego
                    System.out.println("¡Gracias por jugar!");
                    break;  
            
                default:
                    System.out.println("Opción no válida");
                    System.out.println();
            }
        } while (opcion != 3);

    }
}
