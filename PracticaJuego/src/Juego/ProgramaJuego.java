package Juego;

import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;
/**
 * La clase ProgramaJuego permite al usuario seleccionar diferentes opciones como jugar una partida, ver el ranking de jugadores,
 * ver el histórico de partidas y administrar la lista de jugadores.
 *
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class ProgramaJuego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		Jugador jugador = new Jugador(null);
		ArrayList<Jugador> listahumanos = new ArrayList<Jugador>(); 
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
				Historico.mostrarFichero();
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
						jugador.ayadirJugadorHumano(new Jugador(jugadorAyadido));
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
