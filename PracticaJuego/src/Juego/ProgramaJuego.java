package Juego;

import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;

public class ProgramaJuego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		JugadorHumano jugador = new JugadorHumano(null);
		ArrayList<JugadorHumano> listahumanos = new ArrayList<JugadorHumano>(); 
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
				
				Partida.numeroJugadores();
				System.out.println("Empieza la partida");
				Partida.tipoPartida();
				
				
				break;
			case 2:
				Ranking.crearFicheroRanking();
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
						jugador.ayadirJugador(new JugadorHumano(jugadorAyadido));
						break;
					case 3:
						System.out.println("Dime el nombre del jugador que quieres eliminar");
						String jugadorEliminado = teclado.next();
						jugador.eliminarJugador(new JugadorHumano(jugadorEliminado));
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
