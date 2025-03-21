public class Pokemon {
    private String nombre;
    private Tipo[] tipo = {Tipo.FUEGO, Tipo.PLANTA, Tipo.ELECTRICO, Tipo.AGUA};
    private int puntosSalud;

    
    public Pokemon(String nombre, Pokemon.Tipo[] tipo, int puntosSalud) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntosSalud = puntosSalud;
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

    public Tipo[] getTipo() {
        return tipo;
    }

    public void setTipo(Tipo[] tipo) {
        this.tipo = tipo;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    
}