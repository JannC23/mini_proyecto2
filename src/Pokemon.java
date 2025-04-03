import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
    private String nombre;
    private Tipo tipo;
    private int puntosSalud;
    private Ataque[] ataques = new Ataque[4];
    private int numero;

    // Constructor que usa el enum PokemonEnum
    public Pokemon(PokemonEnum pokemonEnum) {
        this.numero = pokemonEnum.getNumero();
        this.nombre = pokemonEnum.getNombre();
        this.tipo = pokemonEnum.getTipo();
        this.puntosSalud = pokemonEnum.getPuntosSalud();
    }

    public enum Tipo {
        FUEGO, PLANTA, ELECTRICO, AGUA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static ArrayList<Pokemon> seleccionarEquipoPokemon() {
        Scanner entrada = new Scanner(System.in);
        PokemonEnum[] listaPokemon = PokemonEnum.values();
        ArrayList<Pokemon> equipo = new ArrayList<>(); // Lista de los 3 Pokemon seleccionados
        boolean[] ocupados = new boolean[listaPokemon.length]; // Array para marcar los Pokemon seleccionados

        for (int j = 0; j < 3; j++) { // Seleccionar 3 Pokemon
            System.out.println("\nSelecciona el Pokemon " + (j + 1) + ":");
            for (int i = 0; i < listaPokemon.length; i++) { // Mostrar lista de Pokemon disponibles
                System.out.println((i + 1) + ". " + listaPokemon[i].getNombre() + " (TIPO: " + listaPokemon[i].getTipo() + ") - VIDA: " + listaPokemon[i].getPuntosSalud());
            }

            int opcion;
            Pokemon pokemonSeleccionado = null;

            do {
                System.out.print("\nIngresa el numero del Pokemon que deseas (1-" + listaPokemon.length + "): ");
                opcion = entrada.nextInt();

                // Verificar si la opcion es valida y si el Pokemon ya fue elegido
                if (opcion >= 1 && opcion <= listaPokemon.length) {
                    if (!ocupados[opcion - 1]) { // Verificar si el Pokemon no ha sido seleccionado antes
                        pokemonSeleccionado = new Pokemon(listaPokemon[opcion - 1]); // Crear el Pokemon
                        ocupados[opcion - 1] = true; // Marcar como seleccionado
                    } else {
                        System.out.println("Ese Pokemon ya fue seleccionado. Elige otro.");
                    }
                } else {
                    System.out.println("Opcion no valida. Intenta nuevamente.");
                }
            } while (pokemonSeleccionado == null); // Repetir hasta que se seleccione un Pokemon valido

            equipo.add(pokemonSeleccionado); // Agregar al equipo
        }

        return equipo; // Retorna el equipo completo
    }

    public static ArrayList<Pokemon> crearPokemonAleatorio() {
        PokemonEnum[] listaPokemon = PokemonEnum.values();
        ArrayList<Pokemon> equipo = new ArrayList<>(); // Lista para almacenar los 3 Pokemon seleccionados
        boolean[] ocupados = new boolean[listaPokemon.length]; // Array para marcar los Pokemon seleccionados

        for (int i = 0; i < 3; i++) { // Generar 3 Pokemon aleatorios
            Pokemon pokemonAleatorio;
            int numeroAleatorio;

            do {
                numeroAleatorio = (int) (Math.random() * listaPokemon.length); // Generar un numero aleatorio
                if (!ocupados[numeroAleatorio]) { // Verificar si el Pokemon no ha sido seleccionado antes
                    pokemonAleatorio = new Pokemon(listaPokemon[numeroAleatorio]); // Crear el Pokemon
                    ocupados[numeroAleatorio] = true; // Marcar como seleccionado
                    break;
                } else {
                    pokemonAleatorio = null; // Reiniciar si ya fue seleccionado
                }
            } while (pokemonAleatorio == null); // Repetir hasta que se genere un Pokemon valido

            equipo.add(pokemonAleatorio); // Agregar al equipo
        }

        return equipo; // Retorna el equipo completo
    }
}