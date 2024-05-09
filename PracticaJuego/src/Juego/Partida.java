package Juego;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partida {

	static void hacerPregunta() {
		Random aleatorio = new Random();
		Scanner teclado = new Scanner(System.in);
		int numeroPregunta = aleatorio.nextInt(3) + 1;
		if (numeroPregunta == Constantes.PREGUNTAS_MATES) {
			PreguntaMates preguntaMates = new PreguntaMates();
			preguntaMates.generarOperacion();
			int numero = teclado.nextInt();
			preguntaMates.comprobarResultado(numero);

		} else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
			PreguntaLetras preguntaLetras = new PreguntaLetras();
			System.out.println(preguntaLetras.getPalabraOculta());
			String palabra = teclado.next();
			preguntaLetras.palabraCorrecta(palabra);

		} else {
			PreguntaIngles preguntaIngles = new PreguntaIngles();
			preguntaIngles.mostrarPregunta();
			char letra = teclado.next().toUpperCase().charAt(0);
			preguntaIngles.comprobarRespuesta(letra);
		}
	}

	static void numeroJugadores() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Maximo de jugadores son: 4 ");
		System.out.println("Dime el numero de jugadores humanos vais a ser: 1-4");
		int jugadorHumano = teclado.nextInt();
		System.out.println("Dime el numero de jugadores maquina vas a querer: 1-4");
		int jugadorMaquina = teclado.nextInt();
		int totalJugadores = jugadorHumano + jugadorMaquina;
		if (totalJugadores > 4 || jugadorHumano < 0 || jugadorMaquina < 0) {
			System.out.println("Número de jugadores inválido.");
		}
		for (int contador = 0; contador < jugadorHumano; contador++) {
            System.out.print("Ingrese el nombre del jugador humano " + (contador + 1) + ": ");
            String nombre = teclado.next();
            Jugador jugador = new Jugador(nombre);
            jugador.comprobarJugador(jugador);
        }
	}

}
