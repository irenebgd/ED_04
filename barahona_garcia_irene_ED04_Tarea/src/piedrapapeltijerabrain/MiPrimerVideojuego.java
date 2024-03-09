/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/

package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 * Juego de Piedra, Papel, Tijera con un propósito definido.
 * El propósito puede ser ganar o perder, y el jugador debe intentar cumplir ese propósito
 * a través de sus elecciones de jugada.
 *
 * @author Irene Barahona García
 */
public class MiPrimerVideojuego {

    /**
     * Método principal que inicia el juego de Piedra, Papel, Tijera.
     * Se ejecuta el juego por 5 rondas, donde el jugador elige su jugada y se compara
     * con la jugada del bot. Dependiendo del propósito (ganar o perder), el jugador
     * debe tratar de alcanzarlo.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso)
     */
    public static void main(String[] args) {
        int chiquipuntos = 0;  // Puntuación del jugador
        Scanner sc = new Scanner(System.in);
        String opcionJugador = "";  // Jugada del jugador
        String opcionBot = "";      // Jugada del bot
        int exitoEnProposito = 1;   // Éxito en el propósito, inicializado en 1
        long inicio = System.currentTimeMillis();  // Tiempo de inicio del juego

        // Loop de 5 rondas del juego
        for (int i = 0; i < 5; i++) {
            // Generar un propósito aleatorio (1 para ganar, 2 para perder)
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }

            // Generar jugada aleatoria para el bot (tijera, papel, piedra)
            int j = (int) Math.floor(Math.random() * 3 + 1);
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }

            // Solicitar la jugada del jugador y validar
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot == opcionJugador);

            // Determinar el resultado de la ronda y ajustar la puntuación
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }

            // Ajustar el resultado según el propósito
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }

            // Incrementar la puntuación si el jugador tuvo éxito en el propósito
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }

        // Calcular el tiempo total y mostrar resultados
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");

        // Calcular penalización por fallos y tiempo final
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
    }

    /**
     * Método para mostrar la representación visual de "tijera".
     */
    public static void tijera() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " __________)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }

    /**
     * Método para mostrar la representación visual de "papel".
     */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " _______)\n"
                + " _______)\n"
                + "---.__________)");
    }

    /**
     * Método para mostrar la representación visual de "piedra".
     */
    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + " (_____)\n"
                + " (_____)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}