import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Intefaz {
    private JFrame frame;
    private Entrenador entrenador1 = null;
    private Entrenador entrenador2 = null;

    public Intefaz() {
        // Crear el menu principal
        frame = new JFrame("Menú Principal - Mundo Pokémon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 1, 10, 10)); // 7 filas para los botones y el título

        JLabel titulo = new JLabel("¡Bienvenido al Mundo Pokémon!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titulo);

        // Boton donde va todo lo del caso 1
        JButton crearEntrenadorButton = new JButton("1. Crear Entrenador");
        crearEntrenadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre1 = JOptionPane.showInputDialog(frame, "Ingresa el nombre del primer entrenador:");
                if (nombre1 != null && !nombre1.trim().isEmpty()) {
                    entrenador1 = new Entrenador(nombre1);
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre no válido para el primer entrenador.");
                    return;
                }

                String nombre2 = JOptionPane.showInputDialog(frame, "Ingresa el nombre del segundo entrenador:");
                if (nombre2 != null && !nombre2.trim().isEmpty()) {
                    entrenador2 = new Entrenador(nombre2);
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre no válido para el segundo entrenador.");
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Entrenadores creados exitosamente:\n" +
                        "Entrenador 1: " + entrenador1.getNombre() + "\n" +
                        "Entrenador 2: " + entrenador2.getNombre());
            }
        });
        frame.add(crearEntrenadorButton);

        // Boton donde va todo lo del caso 2
        JButton mostrarEntrenadorButton = new JButton("2. Mostrar Entrenador");
        mostrarEntrenadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entrenador1 != null && entrenador2 != null) {
                    JOptionPane.showMessageDialog(frame, "Entrenadores actuales:\n" +
                            "Entrenador 1: " + entrenador1.getNombre() + "\n" +
                            "Entrenador 2: " + entrenador2.getNombre());
                } else {
                    JOptionPane.showMessageDialog(frame, "Primero debes crear los entrenadores.");
                }
            }
        });
        frame.add(mostrarEntrenadorButton);

        // Boton donde va todo lo del caso 3
        JButton seleccionarPokemonButton = new JButton("3. Seleccionar Pokémon");
        seleccionarPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entrenador1 != null && entrenador2 != null) {
                    seleccionarPokemon(entrenador1);
                    seleccionarPokemon(entrenador2);
                } else {
                    JOptionPane.showMessageDialog(frame, "Primero debes crear los entrenadores.");
                }
            }
        });
        frame.add(seleccionarPokemonButton);

        // Boton donde va todo lo del caso 4
        JButton mostrarPokemonButton = new JButton("4. Mostrar Pokémon Seleccionados");
        mostrarPokemonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entrenador1 != null && entrenador2 != null) {
                    mostrarEquipo(entrenador1);
                    mostrarEquipo(entrenador2);
                } else {
                    JOptionPane.showMessageDialog(frame, "Primero debes crear los entrenadores y seleccionar los Pokémon.");
                }
            }
        });
        frame.add(mostrarPokemonButton);

        // Boton donde va todo lo del caso 5
        JButton iniciarBatallaButton = new JButton("5. Iniciar Batalla");
        frame.add(iniciarBatallaButton);

        // Boton donde va todo lo del caso 6
        JButton salirButton = new JButton("6. Salir");
        salirButton.addActionListener(e -> System.exit(0));
        frame.add(salirButton);

        // Mostrar la ventana
        frame.setVisible(true);
    }

    private void seleccionarPokemon(Entrenador entrenador) {
        String[] opciones = {"Seleccionar manualmente", "Generar aleatoriamente"};
        int opcion = JOptionPane.showOptionDialog(
                frame,
                entrenador.getNombre() + ", selecciona tus Pokémon:",
                "Seleccionar Pokémon",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (opcion == 0) {
            // Abrir ventana para selección manual
            abrirVentanaSeleccionManual(entrenador);
        } else if (opcion == 1) {
            // Generación aleatoria
            ArrayList<Pokemon> equipo = Pokemon.crearPokemonAleatorio();
            entrenador.setEquipo(equipo);
            JOptionPane.showMessageDialog(frame, "Equipo generado aleatoriamente para " + entrenador.getNombre());
        } else {
            JOptionPane.showMessageDialog(frame, "No se seleccionó ninguna opción.");
        }
    }

    private void abrirVentanaSeleccionManual(Entrenador entrenador) {
        // Crear un nuevo JDialog para la selección
        JDialog dialog = new JDialog(frame, "Seleccionar Pokémon - " + entrenador.getNombre(), true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Panel para mostrar la lista de Pokémon
        JPanel panelPokemon = new JPanel();
        panelPokemon.setLayout(new GridLayout(0, 1)); // Una lista vertical

        // Obtener la lista de Pokémon disponibles
        PokemonEnum[] listaPokemon = PokemonEnum.values();
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();

        for (PokemonEnum pokemonEnum : listaPokemon) {
            JCheckBox checkBox = new JCheckBox(pokemonEnum.getNombre() + " (Tipo: " + pokemonEnum.getTipo() + ")");
            checkboxes.add(checkBox);
            panelPokemon.add(checkBox);
        }

        // Botón para confirmar la selección
        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(e -> {
            ArrayList<Pokemon> equipo = new ArrayList<>();
            for (int i = 0; i < checkboxes.size(); i++) {
                if (checkboxes.get(i).isSelected()) {
                    equipo.add(new Pokemon(listaPokemon[i]));
                }
            }

            if (equipo.size() == 3) {
                entrenador.setEquipo(equipo);
                JOptionPane.showMessageDialog(dialog, "Equipo seleccionado manualmente para " + entrenador.getNombre());
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Debes seleccionar exactamente 3 Pokémon.");
            }
        });

        // Agregar componentes al diálogo
        dialog.add(new JScrollPane(panelPokemon), BorderLayout.CENTER);
        dialog.add(confirmarButton, BorderLayout.SOUTH);

        // Mostrar el diálogo
        dialog.setVisible(true);
    }

    private void mostrarEquipo(Entrenador entrenador) {
        StringBuilder equipoInfo = new StringBuilder("Equipo de " + entrenador.getNombre() + ":\n");
        for (Pokemon pokemon : entrenador.getEquipo()) {
            equipoInfo.append(pokemon.getNombre())
                    .append(" (HP: ")
                    .append(pokemon.getPuntosSalud())
                    .append(")\n");
        }
        JOptionPane.showMessageDialog(frame, equipoInfo.toString());
    }

    public static void main(String[] args) {
        new Intefaz();
    }
}
