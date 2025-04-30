import java.util.Scanner;

public class MenuPrincipal {
    private Scanner entrada = new Scanner(System.in);
    private Entrenador entrenador1 = null;
    private Entrenador entrenador2 = null;

    public void iniciarMenu() {
        int opcion;

        System.out.println("===============================================");
        System.out.println("¡Bienvenido al Mundo Pokemon!");
        System.out.println("Aqui comienza tu aventura como Entrenador Pokemon.");
        System.out.println("¡Atrevete a ser el mejor como nadie lo fue!");

        do {
            System.out.println("\nMenu principal:");
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Mostrar Entrenador");
            System.out.println("3. Seleccionar Pokemon");
            System.out.println("4. Mostrar los pokemones seleccionados");
            System.out.println("5. Iniciar Batalla");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngresa el nombre del primer entrenador: ");
                    String nombre1 = entrada.nextLine();
                    entrenador1 = new Entrenador(nombre1);

                    System.out.print("\nIngresa el nombre del segundo entrenador: ");
                    String nombre2 = entrada.nextLine();
                    entrenador2 = new Entrenador(nombre2);
                    break;

                case 2:
                    if (entrenador1 != null && entrenador2 != null) {
                        System.out.println("\nEntrenador 1: " + entrenador1.getNombre());
                        System.out.println("Entrenador 2: " + entrenador2.getNombre());
                    } else {
                        System.out.println("\nPrimero debes crear los entrenadores.");
                    }
                    break;

                case 3:
                    if (entrenador1 != null && entrenador2 != null) {
                        seleccionarPokemon(entrenador1);
                        seleccionarPokemon(entrenador2);
                    } else {
                        System.out.println("\nPrimero debes crear los entrenadores.");
                    }
                    break;

                case 4:
                    if (entrenador1 != null && entrenador2 != null) {
                        mostrarEquipo(entrenador1);
                        mostrarEquipo(entrenador2);
                    } else {
                        System.out.println("\nPrimero debes crear los entrenadores y seleccionar los Pokémon.");
                    }
                    break;

                case 5:
                    if (entrenador1 != null && entrenador2 != null) {
                        iniciarBatalla();
                    } else {
                        System.out.println("\nPrimero debes crear los entrenadores y seleccionar los Pokémon.");
                    }
                    break;

                case 6:
                    System.out.println("\n¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    private void seleccionarPokemon(Entrenador entrenador) {
        System.out.println("\n" + entrenador.getNombre() + ", selecciona tus Pokémon:");
        System.out.println("1. Seleccionar manualmente");
        System.out.println("2. Generar aleatoriamente");
        System.out.print("Seleccione una opción: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();

        if (opcion == 1) {
            entrenador.setEquipo(Pokemon.seleccionarEquipoPokemon());
        } else if (opcion == 2) {
            entrenador.setEquipo(Pokemon.crearPokemonAleatorio());
            System.out.println("Equipo generado aleatoriamente para " + entrenador.getNombre());
        } else {
            System.out.println("Opción no válida. Intenta nuevamente.");
        }
    }

    private void mostrarEquipo(Entrenador entrenador) {
        System.out.println("\nEquipo de " + entrenador.getNombre() + ":");
        for (Pokemon pokemon : entrenador.getEquipo()) {
            System.out.println(pokemon.getNombre() + " (HP: " + pokemon.getPuntosSalud() + ")");
        }
    }

    private void iniciarBatalla() {
        if (entrenador1.getEquipo().isEmpty() || entrenador2.getEquipo().isEmpty()) {
            System.out.println("\nAmbos entrenadores deben tener un equipo de Pokémon antes de iniciar la batalla.");
            return;
        }

        System.out.println("\n¡La batalla comienza!");
        Pokemon pokemon1 = entrenador1.elegirPokemonParaBatalla();
        Pokemon pokemon2 = entrenador2.elegirPokemonParaBatalla();

        while (pokemon1.getPuntosSalud() > 0 && pokemon2.getPuntosSalud() > 0) {
            Pokemon primero, segundo;
            Entrenador entrenadorPrimero, entrenadorSegundo;

            // Determinar quién ataca primero
            if (pokemon1.getVelocidad() > pokemon2.getVelocidad()) {
                primero = pokemon1;
                segundo = pokemon2;
                entrenadorPrimero = entrenador1;
                entrenadorSegundo = entrenador2;
            } else if (pokemon1.getVelocidad() < pokemon2.getVelocidad()) {
                primero = pokemon2;
                segundo = pokemon1;
                entrenadorPrimero = entrenador2;
                entrenadorSegundo = entrenador1;
            } else {
                // Si tienen la misma velocidad, decidir al azar
                if (Math.random() < 0.5) {
                    primero = pokemon1;
                    segundo = pokemon2;
                    entrenadorPrimero = entrenador1;
                    entrenadorSegundo = entrenador2;
                } else {
                    primero = pokemon2;
                    segundo = pokemon1;
                    entrenadorPrimero = entrenador2;
                    entrenadorSegundo = entrenador1;
                }
            }

            // Turno del primer Pokémon
            turno(entrenadorPrimero, primero, segundo);
            if (segundo.getPuntosSalud() <= 0) {
                System.out.println("\n" + segundo.getNombre() + " se ha debilitado. ¡" + entrenadorPrimero.getNombre() + " gana!");
                break;
            }

            // Turno del segundo Pokémon
            turno(entrenadorSegundo, segundo, primero);
            if (primero.getPuntosSalud() <= 0) {
                System.out.println("\n" + primero.getNombre() + " se ha debilitado. ¡" + entrenadorSegundo.getNombre() + " gana!");
                break;
            }
        }
    }

    private void turno(Entrenador entrenador, Pokemon atacante, Pokemon defensor) {
        System.out.println("\nTurno de " + entrenador.getNombre() + " (" + atacante.getNombre() + ")");
        Ataque[] ataques = atacante.getAtaques();
        for (int i = 0; i < ataques.length; i++) {
            System.out.println((i + 1) + ". " + ataques[i].getNombre() + " (Potencia: " + ataques[i].getPotencia() + ")");
        }

        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Elige un ataque: ");
            opcion = entrada.nextInt();
            if (opcion < 1 || opcion > ataques.length) {
                System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion < 1 || opcion > ataques.length);

        Ataque ataqueSeleccionado = ataques[opcion - 1];
        int danio = atacante.calcularDanio(ataqueSeleccionado, defensor);
        defensor.recibirDanio(danio);

        System.out.println(atacante.getNombre() + " usó " + ataqueSeleccionado.getNombre() + " y causó " + danio + " puntos de daño.");
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosSalud() + " puntos de salud.");
    }
}
