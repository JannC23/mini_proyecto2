import java.util.Scanner;

public class Pokemon {
    public Scanner scanner = new Scanner(System.in);
    private String nombre;
    private Tipo[] tipo = {Tipo.FUEGO, Tipo.PLANTA, Tipo.ELECTRICO, Tipo.AGUA};
    private int puntosSalud;
    private Ataque[] ataques = new Ataque[4];
    
    public Pokemon(String nombre, Tipo[] tipo, int puntosSalud) {
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