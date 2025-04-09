public enum PokemonEnum {
    CHARMANDER(1, "Charmander", Pokemon.Tipo.FUEGO, 180),
    BULBASAUR(2, "Bulbasaur", Pokemon.Tipo.PLANTA, 200),
    PIKACHU(3, "Pikachu", Pokemon.Tipo.ELECTRICO, 150),
    SQUIRTLE(4, "Squirtle", Pokemon.Tipo.AGUA, 220),
    FLAREON(5, "Flareon", Pokemon.Tipo.FUEGO, 300),
    EEVEE(6, "Leafeon", Pokemon.Tipo.PLANTA, 170),
    LAPRAS(7, "Lapras", Pokemon.Tipo.AGUA, 250),
    MAGNEMITE(8, "Magnemite", Pokemon.Tipo.ELECTRICO, 140);

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
