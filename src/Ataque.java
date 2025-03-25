public class Ataque {
    private String nombre;
    private String tipoDano;
    private int potencia;

    public Ataque(String nombre, String tipoDano, int potencia) {
        this.nombre = nombre;
        this.tipoDano = tipoDano;
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDano() {
        return tipoDano;
    }

    public void setTipoDano(String tipoDano) {
        this.tipoDano = tipoDano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    
}
