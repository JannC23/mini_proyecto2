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
            Pokemon primero = (pokemon1.getPuntosSalud() <= pokemon2.getPuntosSalud()) ? pokemon1 : pokemon2;
            Pokemon segundo = (primero == pokemon1) ? pokemon2 : pokemon1;
            Entrenador entrenadorPrimero = (primero == pokemon1) ? entrenador1 : entrenador2;
            Entrenador entrenadorSegundo = (segundo == pokemon1) ? entrenador1 : entrenador2;

            turno(entrenadorPrimero, primero, segundo);
            if (segundo.getPuntosSalud() <= 0) {
                System.out.println("\n" + segundo.getNombre() + " se ha debilitado. ¡" + entrenadorPrimero.getNombre() + " gana!");
                break;
            }

            turno(entrenadorSegundo, segundo, primero);
            if (primero.getPuntosSalud() <= 0) {
                System.out.println("\n" + primero.getNombre() + " se ha debilitado. ¡" + entrenadorSegundo.getNombre() + " gana!");
                break;
            }
        }
    }

    private void turno(Entrenador entrenador, Pokemon atacante, Pokemon oponente) {
        System.out.println("\nTurno de " + entrenador.getNombre() + " (" + atacante.getNombre() + ")");
        System.out.println("Selecciona un ataque:");
        for (int i = 0; i < atacante.getAtaques().length; i++) {
            if (atacante.getAtaques()[i] != null) {
                System.out.println((i + 1) + ". " + atacante.getAtaques()[i].getNombre());
            }
        }
        int ataqueSeleccionado = entrada.nextInt() - 1;
        int danio = atacante.calcularDanio(atacante.getAtaques()[ataqueSeleccionado], oponente);
        oponente.recibirDanio(danio);
        System.out.println(atacante.getNombre() + " hizo " + danio + " de daño a " + oponente.getNombre());
    }
}
