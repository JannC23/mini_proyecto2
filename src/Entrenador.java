import java.util.ArrayList;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo = new ArrayList<>();
    public Entrenador(String nombre, Pokemon equipo) {
        this.nombre = nombre;
        this.equipo.add(equipo);
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
        if(equipo.size() > 3){
            System.out.println("El equipo no puede tener más de tres Pokémon");
            return;
        }
        this.equipo.clear();
        for(Pokemon pokemon : equipo){
            this.equipo.add(pokemon)
        }
        
    }
    
}
