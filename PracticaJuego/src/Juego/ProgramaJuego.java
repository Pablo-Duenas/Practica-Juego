package Juego;

import java.util.Random;
import java.util.Scanner;

public class ProgramaJuego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
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
					
				}else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
					PreguntaLetras pregunta = new PreguntaLetras();
					System.out.println(pregunta.getPalabraOculta());
					String palabra = teclado.next();
					pregunta.palabraCorrecta(palabra);
					
				}else {
					PreguntaIngles pregunta = new PreguntaIngles();
					pregunta.hacerPregunta();
					System.out.println("dime la opcion correcta");
					String letracorrecta = teclado.next();
					
					if (pregunta.esOpcionValida(letracorrecta)) {
					    if (pregunta.comprobarRespuesta(letracorrecta)) {
					        System.out.println("¡Respuesta correcta!");
					    } else {
					        System.out.println("Respuesta incorrecta");
					    }
					} else {
					    System.out.println("Opción inválida. Por favor, elige entre las opciones a, b, c o d.");
					}
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
					
						
						
						break;
					case 2:
						System.out.println("Dime el nombre del jugador que quieres añadir");
						String jugadorAyadido = teclado.next();
						Jugador nuevoJugador = new Jugador(jugadorAyadido);
						nuevoJugador.ayadirJugador(nuevoJugador);
						break;
					case 3:
						System.out.println("Dime el nombre del jugador que quieres eliminar");
						String jugadorEliminado = teclado.next();
						Jugador nuevoJugador2 = new Jugador(jugadorEliminado);
						nuevoJugador2.eliminarJugador(nuevoJugador2);
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
