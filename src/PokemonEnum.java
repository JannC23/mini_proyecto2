public enum PokemonEnum {
    CHARMANDER(1, "Charmander", Pokemon.Tipo.FUEGO, 200),
    BULBASAUR(2, "Bulbasaur", Pokemon.Tipo.PLANTA, 200),
    PIKACHU(3, "Pikachu", Pokemon.Tipo.ELECTRICO, 200),
    SQUIRTLE(4, "Squirtle", Pokemon.Tipo.AGUA, 200),
    FLAREON(5, "Flareon", Pokemon.Tipo.FUEGO, 200),
    EEVEE(6, "Leafeon", Pokemon.Tipo.PLANTA, 200),
    LAPRAS(7, "Lapras", Pokemon.Tipo.AGUA, 200),
    MAGNEMITE(8, "Magnemite", Pokemon.Tipo.ELECTRICO, 200);

    private final int numero; // Número único para cada Pokémon
    private final String nombre;
    private final Pokemon.Tipo tipo;
    private final int puntosSalud;

    PokemonEnum(int numero, String nombre, Pokemon.Tipo tipo, int puntosSalud) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.puntosSalud = puntosSalud;
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

}
