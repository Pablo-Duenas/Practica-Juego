package Juego;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
/**
 * La clase Partida gestiona las partidas del juego.
 * 
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class Partida {
	static Random aleatorio = new Random();
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	/**
     * Hace una pregunta al jugador Humano.
     * 
     * @param jugador El jugador al que se le hace la pregunta de mates, letras e ingles.
     */
	static void hacerPregunta(Jugador jugador) {
		int numeroPregunta = aleatorio.nextInt(3) + 1;
		if (numeroPregunta == Constantes.PREGUNTAS_MATES) {
			PreguntaMates preguntaMates = new PreguntaMates();
			preguntaMates.generarOperacion();
			int numero = teclado.nextInt();
			if (preguntaMates.comprobarResultado(numero)) {
				jugador.sumarPuntos();
			}
		} else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
			PreguntaLetras preguntaLetras = new PreguntaLetras();
			System.out.println(preguntaLetras.getPalabraOculta());
			String palabra = teclado.next();
			if (preguntaLetras.palabraCorrecta(palabra)) {
				jugador.sumarPuntos();
			}
		} else {
			PreguntaIngles preguntaIngles = new PreguntaIngles();
			preguntaIngles.mostrarPregunta();
			char letra = teclado.next().toUpperCase().charAt(0);
			if (preguntaIngles.comprobarRespuesta(letra)) {
				jugador.sumarPuntos();
			}
		}
	}
	/**
     * Hace una pregunta a un jugador máquina.
     * 
     * @param maquina El jugador máquina al que se le hace la pregunta de mates, letras e ingles.
     */
	public static void hacerPreguntaMaquina(Jugador maquina) {
		int numeroPregunta = aleatorio.nextInt(3) + 1;
		if (numeroPregunta == Constantes.PREGUNTAS_MATES) {
			PreguntaMates preguntaMates = new PreguntaMates();
			preguntaMates.generarOperacion();
			System.out.println(preguntaMates.solucionMatesMaquina(preguntaMates));
			System.out.println("La respuesta es correcta");
			maquina.sumarPuntos();

		} else if (numeroPregunta == Constantes.PREGUNTAS_LETRAS) {
			PreguntaLetras preguntaLetras = new PreguntaLetras();
			System.out.println(preguntaLetras.getPalabraOculta());
			preguntaLetras.palabraCorrecta(preguntaLetras.solucionLetrasMaquina());
		} else {
			PreguntaIngles preguntaIngles = new PreguntaIngles();
			preguntaIngles.mostrarPregunta();
			preguntaIngles.solucionInglesMaquina();

			if (preguntaIngles.comprobarRespuesta(preguntaIngles.solucionInglesMaquina())) {

				maquina.sumarPuntos();
			}
		}
	}
	/**
     * Pide al usuario que le diga el número de jugadores humanos y maquinas que quiere, 
     */
	static boolean numeroJugadores() {
		Jugador jugador = new Jugador(null);
		System.out.println("¿Numero de jugadores humanos? (1-4)");
		int jugadorHumano = teclado.nextInt();
		System.out.println("¿Numero de jugadores CPU? (1-4)");
		int jugadorMaquina = teclado.nextInt();
		int totalJugadores = jugadorHumano + jugadorMaquina;
		if (totalJugadores <= Constantes.Jugadores_Maximos && (jugadorHumano > 0 || jugadorMaquina > 0)) {
			for (int contador = 0; contador < jugadorHumano; contador++) {
				System.out.println("Jugador humano " + (contador + 1) + ":");
				String nombre = teclado.next();
				Jugador.comprobarJugador(nombre);
				;
			}

			for (int contador = 0; contador < jugadorMaquina; contador++) {
				String maquina = "cpu" + contador;
				System.out.println(maquina);
				jugador.ayadirJugador(new Jugador(maquina));
				Jugador.comprobarJugador(maquina);
			}
			return true;
		} else {
			System.out.println("Número de jugadores inválidos");
		}
		return false;
	}
    /**
     * Le dice al usuario que elija el tipo de partida que quiere jugar.
     */
	public static void tipoPartida() {

		System.out.println("Elije el tipo de partida que quieres jugar: ");
		System.out.println("1. Partida rápida (3 rondas)");
		System.out.println("2. Partida corta (5 rondas)");
		System.out.println("3. Partida normal (10 rondas)");
		System.out.println("4. Partida larga (20 rondas)");
		int opcion = teclado.nextInt();

		switch (opcion) {
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
    /**
     * Realiza una partida rápida.
     */
	public static void partidaRapida() {
		ArrayList<Jugador> jugadores = Jugador.listaJugadoresPartida();
		Collections.shuffle(jugadores);
		for (int contador = 0; contador < Constantes.Partida_Rapida; contador++) {
			System.out.println("Ronda: " + (contador + 1));

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().endsWith("0") || jugador.getNombre().endsWith("1")
						|| jugador.getNombre().endsWith("2") || jugador.getNombre().endsWith("3")) {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPreguntaMaquina(jugador);

				} else {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPregunta(jugador);
				}
			}
		}
		Historico.crearFicheroHistorico();
		Historico.registrarPartida();

	}
    /**
     * Realiza una partida corta.
     */
	public static void partidaCorta() {
		ArrayList<Jugador> jugadores = Jugador.listaJugadoresPartida();
		Collections.shuffle(jugadores);
		for (int contador = 0; contador < Constantes.Partida_Corta; contador++) {
			System.out.println("Ronda: " + (contador + 1));

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().endsWith("0") || jugador.getNombre().endsWith("1")
						|| jugador.getNombre().endsWith("2") || jugador.getNombre().endsWith("3")) {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPreguntaMaquina(jugador);

				} else {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPregunta(jugador);
				}
			}
		}
		Historico.crearFicheroHistorico();
		Historico.registrarPartida();
	}
    /**
     * Realiza una partida normal.
     */
	public static void partidaNormal() {
		ArrayList<Jugador> jugadores = Jugador.listaJugadoresPartida();
		Collections.shuffle(jugadores);
		for (int contador = 0; contador < Constantes.Partida_Normal; contador++) {
			System.out.println("Ronda: " + (contador + 1));

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().endsWith("0") || jugador.getNombre().endsWith("1")
						|| jugador.getNombre().endsWith("2") || jugador.getNombre().endsWith("3")) {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPreguntaMaquina(jugador);

				} else {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPregunta(jugador);
				}
			}
		}
		Historico.crearFicheroHistorico();
		Historico.registrarPartida();
	}
    /**
     * Realiza una partida larga.
     */
	public static void partidaLarga() {
		ArrayList<Jugador> jugadores = Jugador.listaJugadoresPartida();
		Collections.shuffle(jugadores);
		for (int contador = 0; contador < Constantes.Partida_Larga; contador++) {
			System.out.println("Ronda: " + (contador + 1));

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().endsWith("0") || jugador.getNombre().endsWith("1")
						|| jugador.getNombre().endsWith("2") || jugador.getNombre().endsWith("3")) {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPreguntaMaquina(jugador);

				} else {
					System.out.println("Turno del Jugador:" + jugador);
					hacerPregunta(jugador);
				}
			}
		}
		Historico.crearFicheroHistorico();
		Historico.registrarPartida();
	}

}
