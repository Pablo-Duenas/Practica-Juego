package Juego;

import java.util.Random;
import java.util.Scanner;

public class ProgramaJuego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		Jugador jugador = new Jugador(null);
		int opcion = 0;
		while(opcion != 5) {
			System.out.println("1. Jugar Partida.");
			System.out.println("2. Ranking De Jugadores.");
			System.out.println("3. Histórico De Partidas.");
			System.out.println("4. Jugadores.");
			System.out.println("5. Salir.");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				int numeroPregunta = aleatorio.nextInt(3) + 1;
				if (numeroPregunta == Constantes.PREGUNTAS_MATES) {
					PreguntaMates preguntaMates = new PreguntaMates();
					preguntaMates.generarOperacion();
					int numero = teclado.nextInt();
					preguntaMates.comprobarResultado(numero);
					
				}else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
					PreguntaLetras preguntaLetras = new PreguntaLetras();
					System.out.println(preguntaLetras.getPalabraOculta());
					String palabra = teclado.next();
					preguntaLetras.palabraCorrecta(palabra);
					
				}else {
					 PreguntaIngles preguntaIngles = new PreguntaIngles();
				     preguntaIngles.mostrarPregunta();
				     char letra = teclado.next().toUpperCase().charAt(0);
				     preguntaIngles.comprobarRespuesta(letra);
				}
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				int opcionJugador = 0;
				while(opcionJugador != 4) {
					System.out.println("1. Ver Jugadores");
					System.out.println("2. Añadir jugador");
					System.out.println("3. Eliminar jugador");
					System.out.println("4. Volver");
					opcionJugador = teclado.nextInt();
					
					switch (opcionJugador) {
					case 1:
						System.out.println("Lista de Jugadores");
						jugador.mostrarJugadores();
						break;
					case 2:
						System.out.println("Dime el nombre del jugador que quieres añadir");
						String jugadorAyadido = teclado.next();
						jugador.ayadirJugador(new Jugador(jugadorAyadido));
						break;
					case 3:
						System.out.println("Dime el nombre del jugador que quieres eliminar");
						String jugadorEliminado = teclado.next();
						jugador.eliminarJugador(new Jugador(jugadorEliminado));
						break;
					case 4:
						System.out.println("Llendo al menu principal...");
						break;
					default:
						System.out.println("Esa no es una opción");
						break;
					}
				}
				break;
			case 5:
				System.out.println("Hasta la proxima...");
				break;
			default:
				System.out.println("Esa no es una opción");
				break;
			}
		}
	}

}
