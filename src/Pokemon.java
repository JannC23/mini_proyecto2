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
        asignarAtaquesPredeterminados(); // Asignar ataques al crear el Pokémon
    }

    private void asignarAtaquesPredeterminados() {
        switch (this.tipo) {
            case FUEGO:
                this.ataques[0] = new Ataque("Lanzallamas", "Especial", 50);
                this.ataques[1] = new Ataque("Ascuas", "Especial", 30);
                this.ataques[2] = new Ataque("Giro Fuego", "Especial", 40);
                this.ataques[3] = new Ataque("Colmillo Ígneo", "Físico", 45);
                break;
            case AGUA:
                this.ataques[0] = new Ataque("Pistola Agua", "Especial", 40);
                this.ataques[1] = new Ataque("Hidrobomba", "Especial", 60);
                this.ataques[2] = new Ataque("Surf", "Especial", 50);
                this.ataques[3] = new Ataque("Aqua Jet", "Físico", 35);
                break;
            case PLANTA:
                this.ataques[0] = new Ataque("Hoja Afilada", "Especial", 50);
                this.ataques[1] = new Ataque("Latigazo", "Físico", 40);
                this.ataques[2] = new Ataque("Rayo Solar", "Especial", 60);
                this.ataques[3] = new Ataque("Drenadoras", "Especial", 30);
                break;
            case ELECTRICO:
                this.ataques[0] = new Ataque("Impactrueno", "Especial", 40);
                this.ataques[1] = new Ataque("Rayo", "Especial", 50);
                this.ataques[2] = new Ataque("Trueno", "Especial", 60);
                this.ataques[3] = new Ataque("Chispa", "Físico", 35);
                break;
        }
    }

    public enum Tipo {
        FUEGO, PLANTA, ELECTRICO, AGUA;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void recibirDanio(int danio) {
        this.puntosSalud -= danio;
        if (this.puntosSalud < 0) {
            this.puntosSalud = 0;
        }
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }

    public int calcularDanio(Ataque ataque, Pokemon oponente) {
        int danio = (int) Math.round(ataque.getPotencia());
        if (tieneVentaja(oponente)) {
            danio += danio * 0.3; // Aumenta el daño en un 30% si hay ventaja de tipo
        }
        return danio;
    }

    private boolean tieneVentaja(Pokemon oponente) {
        if (this.tipo == Tipo.FUEGO && oponente.tipo == Tipo.PLANTA) return true;
        if (this.tipo == Tipo.AGUA && oponente.tipo == Tipo.FUEGO) return true;
        if (this.tipo == Tipo.PLANTA && oponente.tipo == Tipo.AGUA) return true;
        return false;
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