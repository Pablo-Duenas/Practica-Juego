package Juego;

import java.util.Iterator;
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
	}
	static void partidaRapida() {
			for (int contador2 = 0; contador2 < Constantes.Partida_Rapida; contador2++) {
				hacerPregunta();
			}
			
		
		
	}
	static void partidaCorta() {
		for (int contador = 0; contador < Constantes.Partida_Corta; contador++) {
			hacerPregunta();
		}
		
	}
	static void partidaNormal() {
		for (int contador = 0; contador < Constantes.Partida_Normal; contador++) {
			hacerPregunta();
		}
		
	}
	static void partidaLarga() {
		for (int contador = 0; contador < Constantes.Partida_Larga; contador++) {
			hacerPregunta();
		}
		
	}
	static void numeroRondas() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elige uno de estos cuatro tipos de rondas");
		System.out.println("1) 3 Partida Rápida");
		System.out.println("2) 5 Partida Corta");
		System.out.println("3) 10 Partida Normal");
		System.out.println("4) 20 Partida Larga");
		int opcion = teclado.nextInt(); 
		
		switch (opcion) {
		case 1:
				
				partidaRapida();
			
			break;
		case 2:
			partidaCorta();
			break;
		case 3:
			partidaNormal();
			break;
		case 4:
			partidaLarga();
			break;
		default:
			System.out.println("Esa no es una opcion");
			break;
		}
	}
	static void numeroJugadores() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime cuantos jugadores humanos vais a ser: 1-4");
		int numeroJugadores = teclado.nextInt();
		System.out.println("Dime cuantos jugadores maquinas vais a querer : 1-4");
		int numeroMaquinas = teclado.nextInt();
		
		if (numeroJugadores + numeroMaquinas > 4) {
			System.out.println("No puede haber mas de 4 jugadores jugando a la vez");
		}else {
			for (int contador = 0; contador < numeroJugadores; contador++) {
				System.out.println("Dime el nombre del jugador");
				String nombre = teclado.next();
				Jugador jugador = new Jugador(nombre);
				if (jugador.getListaJugadores().contains(jugador)) {
					System.out.println("El jugador esta registrado");
					
				}else {
					System.out.println("Este jugador no esta registrado");
					jugador.ayadirJugador(jugador);
				}
				
			}
			for (int contador = 0; contador < numeroMaquinas; contador++) {
				
			}
		}
		
		
		
	}


	
	
}
