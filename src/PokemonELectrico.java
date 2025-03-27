public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, Tipo[] tipo, int puntosSalud){
        super(nombre, new Tipo[]{Tipo.ELECTRICO}, puntosSalud);
    }
}
