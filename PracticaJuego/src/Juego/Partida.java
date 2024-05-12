package Juego;

import java.util.ArrayList;  
import java.util.Random;
import java.util.Scanner;

public class Partida {
	static Random aleatorio = new Random();
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	static void hacerPregunta(Jugador jugador) {
		int numeroPregunta = aleatorio.nextInt(3) + 1;
		if (numeroPregunta == Constantes.PREGUNTAS_MATES) {
			PreguntaMates preguntaMates = new PreguntaMates();
			preguntaMates.generarOperacion();
			int numero = teclado.nextInt();
			if (preguntaMates.comprobarResultado(numero)) {
				Jugador.sumarPuntos();
			}
		} else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
			PreguntaLetras preguntaLetras = new PreguntaLetras();
			System.out.println(preguntaLetras.getPalabraOculta());
			String palabra = teclado.next();
			if (preguntaLetras.palabraCorrecta(palabra)) {
				Jugador.sumarPuntos();
			}
		} else {
			PreguntaIngles preguntaIngles = new PreguntaIngles();
			preguntaIngles.mostrarPregunta();
			char letra = teclado.next().toUpperCase().charAt(0);
			if (preguntaIngles.comprobarRespuesta(letra)) {
				Jugador.sumarPuntos();
			}
		}
	}
	static void numeroJugadores() {
		System.out.println("¿Numero de jugadores humanos? (1-4)");
		int jugadorHumano = teclado.nextInt();
		System.out.println("¿Numero de jugadores CPU? (1-4)");
		int jugadorMaquina = teclado.nextInt();
		int totalJugadores = jugadorHumano + jugadorMaquina;
		if (totalJugadores <= Constantes.Jugadores_Maximos && (jugadorHumano > 0 || jugadorMaquina > 0 )){
			for (int contador = 0; contador < jugadorHumano; contador++) {
				System.out.println("Jugador humano " +(contador + 1) + ":");
				String nombre = teclado.next();
				JugadorHumano.comprobarJugador(nombre);;
			}
			
			for (int contador = 0; contador < jugadorMaquina; contador++) {
				System.out.println("CPU"+contador);
				JugadorMaquina.anyadirCPU(jugadorMaquina + (contador+1));
			}
		}else {
			System.out.println("Número de jugadores inválidos");
		}	
	}
	
	public static void tipoPartida() {
		
		 System.out.println("Elije el tipo de partida que quieres jugar: ");
	        System.out.println("1. Partida rápida (3 rondas)");
	        System.out.println("2. Partida corta (5 rondas)");
	        System.out.println("3. Partida normal (10 rondas)");
	        System.out.println("4. Partida larga (20 rondas)");
	        int opcion = teclado.nextInt();

	        switch (opcion){
	            case 1:
	            	Partida.partidaRapida();
	                break;
	            case 2:
	            	Partida.partidaCorta();
	                break;
	            case 3:
	            	Partida.partidaNormal();
	                break;
	            case 4:
	            	Partida.partidaLarga();
	                break;
	            default:
	                System.out.println("Esa opción no es válida");
	                break;
	        }
		
		
	}
	
	 public static void partidaRapida(){
	        jugadores.addAll(JugadorHumano.getListaJugadores());
	        for (int contador = 0; contador < Constantes.Partida_Rapida; contador++) {
	            System.out.println("Ronda: " + (contador+1));

	            for (Jugador jugador: jugadores){
	                System.out.println("Turno de: " + jugador);
	                hacerPregunta(jugador);
	            }
	        }
	    }
	 public static void partidaCorta(){
	        jugadores.addAll(JugadorHumano.getListaJugadores());
	        for (int contador = 0; contador < Constantes.Partida_Corta; contador++) {
	            System.out.println("Ronda: " + (contador+1));

	            for (Jugador jugador: jugadores){
	                System.out.println("Turno de: " + jugador);
	                hacerPregunta(jugador);
	            }
	        }
	    }
	 public static void partidaNormal(){
	        jugadores.addAll(JugadorHumano.getListaJugadores());
	        for (int contador = 0; contador < Constantes.Partida_Normal; contador++) {
	            System.out.println("Ronda: " + (contador+1));

	            for (Jugador jugador: jugadores){
	                System.out.println("Turno de: " + jugador);
	                hacerPregunta(jugador);
	            }
	        }
	    }
	 public static void partidaLarga(){
	        jugadores.addAll(JugadorHumano.getListaJugadores());
	        for (int contador = 0; contador < Constantes.Partida_Larga; contador++) {
	            System.out.println("Ronda: " + (contador+1));

	            for (Jugador jugador: jugadores){
	                System.out.println("Turno de: " + jugador);
	                hacerPregunta(jugador);
	            }
	        }
	    }
	

}
