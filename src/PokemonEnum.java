public enum PokemonEnum {
    CHARMANDER(1, "Charmander", Pokemon.Tipo.FUEGO, 180, 52, 43, 60, 50, 65),
    BULBASAUR(2, "Bulbasaur", Pokemon.Tipo.PLANTA, 200, 49, 49, 65, 65, 45),
    PIKACHU(3, "Pikachu", Pokemon.Tipo.ELECTRICO, 150, 55, 40, 50, 50, 90),
    SQUIRTLE(4, "Squirtle", Pokemon.Tipo.AGUA, 220, 48, 65, 50, 64, 43);

    private final int numero;
    private final String nombre;
    private final Pokemon.Tipo tipo;
    private final int puntosSalud;
    private final int ataque;
    private final int defensa;
    private final int ataqueEspecial;
    private final int defensaEspecial;
    private final int velocidad;

    PokemonEnum(int numero, String nombre, Pokemon.Tipo tipo, int puntosSalud, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntosSalud = puntosSalud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon.Tipo getTipo() {
        return tipo;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }
}
