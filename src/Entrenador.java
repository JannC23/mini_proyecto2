public class Entrenador {
    private String nombre;
    private String[] Equipo = new String[2];
    
    public Entrenador(String nombre, String[] equipo) {
        this.nombre = nombre;
        Equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getEquipo() {
        return Equipo;
    }

    public void setEquipo(String[] equipo) {
        Equipo = equipo;
    }
    
}
