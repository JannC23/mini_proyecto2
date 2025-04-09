import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Pokemon> equipo) {
        if (equipo.size() > 3) {
            System.out.println("El equipo no puede tener más de tres Pokémon");
            return;
        }
        this.equipo.clear();
        for (Pokemon pokemon : equipo) {
            this.equipo.add(pokemon);
        }
    }

    public Pokemon elegirPokemonParaBatalla() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n" + nombre + ", selecciona un Pokémon para la batalla:");
        for (int i = 0; i < equipo.size(); i++) {
            Pokemon pokemon = equipo.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNombre() + " (HP: " + pokemon.getPuntosSalud() + ")");
        }
        int opcion;
        do {
            System.out.print("Seleccione el número del Pokémon: ");
            opcion = entrada.nextInt();
            if (opcion < 1 || opcion > equipo.size()) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > equipo.size());
        return equipo.get(opcion - 1);
    }
}