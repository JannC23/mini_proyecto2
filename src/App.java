import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Entrenador[] entrenadores = new Entrenador[2]; // Arreglo de objetos Entrenador

        // Solicitar los nombres de los entrenadores
        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del entrenador " + (i + 1) + ": ");
            String nombre = entrada.nextLine();
            entrenadores[i] = new Entrenador(nombre, new String[3]); // Crear un objeto Entrenador
            System.out.println();
        }

        // Imprimir los nombres de los entrenadores
        for (int i = 0; i < 2; i++) {
            System.out.println("El nombre del entrenador " + (i + 1) + " es: " + entrenadores[i].getNombre());
        }

    }
}
