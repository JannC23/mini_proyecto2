import java.util.Scanner;

public class MenuPrincipal {
    private Scanner entrada = new Scanner(System.in);
    private Entrenador entrenador1 = null; // Inicialmente nulos
    private Entrenador entrenador2 = null; // Inicialmente nulos

    public void iniciarMenu() {
        int opcion;

        // Introduccion al juego
        System.out.println("===============================================");
        System.out.println("¡Bienvenido al Mundo Pokemon!");
        System.out.println("Aqui comienza tu aventura como Entrenador Pokemon.");
        System.out.println("Preparate para demostrar tus habilidades y formar el mejor equipo.");
        System.out.println("¡Atrevete a ser el mejor como nadie lo fue!");

        do {
            System.out.println("\nMenu principal:"); // Menu principal del juego
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Mostrar Entrenador");
            System.out.println("3. Seleccionar Pokemon");
            System.out.println("4. Mostrar los pokemones seleccionados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de linea

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
                    // Seleccionar Pokemon
                    int opcionPokemon;
                    System.out.println("\n1. Seleccionar pokemon manualmente: ");
                    System.out.println("2. Seleccionar pokemon aleatoriamente: ");
                    System.out.print("Seleccione una opcion: ");
                    opcionPokemon = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcionPokemon) {
                        case 1:
                            if (entrenador1 != null && entrenador2 != null) {
                                System.out.println("\n" + entrenador1.getNombre() + ", selecciona los 3 pokemones con los que quieres luchar:");
                                entrenador1.setEquipo(Pokemon.seleccionarEquipoPokemon()); // Seleccion de Pokemon para el primer entrenador

                                System.out.println("\n" + entrenador2.getNombre() + ", selecciona los 3 pokemones con los que quieres luchar:");
                                entrenador2.setEquipo(Pokemon.seleccionarEquipoPokemon()); // Seleccion de Pokemon para el segundo entrenador
                            } else {
                                System.out.println("Primero debes crear los entrenadores.");
                            }
                            break;

                        case 2:
                            if (entrenador1 != null && entrenador2 != null) {
                                System.out.println("\nLos equipos de cada entrenador fueron creados exitosamente:");
                                entrenador1.setEquipo(Pokemon.crearPokemonAleatorio()); // Seleccion de Pokemon aleatoriamente para el primer entrenador
                                entrenador2.setEquipo(Pokemon.crearPokemonAleatorio()); // Seleccion de Pokemon aleatoriamente para el segundo entrenador
                            } else {
                                System.out.println("Primero debes crear los entrenadores.");
                            }
                            break;

                        default:
                            System.out.println("Opcion no valida. Intente nuevamente.");
                            break;
                    }
                    break;

                case 4:
                    // Mostrar los Pokemon seleccionados
                    if (entrenador1 != null && entrenador2 != null) {
                        System.out.println("\nPokemon de " + entrenador1.getNombre() + ":");
                        for (Pokemon pokemon : entrenador1.getEquipo()) {
                            System.out.println(pokemon.getNombre() + " (TIPO " + pokemon.getTipo() + ") - VIDA (" + pokemon.getPuntosSalud() + ")");
                        }

                        System.out.println("\nPokemon de " + entrenador2.getNombre() + ":");
                        for (Pokemon pokemon : entrenador2.getEquipo()) {
                            System.out.println(pokemon.getNombre() + " (TIPO " + pokemon.getTipo() + ") - VIDA (" + pokemon.getPuntosSalud() + ")");
                        }
                    } else {
                        System.out.print("\nPrimero debes crear los entrenadores y seleccionar los Pokemon.");
                    }
                    break;

                case 5:
                    // Terminar el juego
                    System.out.println("\n¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
            System.out.println(); // Espacio entre iteraciones del menu
        } while (opcion != 5); // Cambie la opcion de salida a 4

        entrada.close();
    }
}
