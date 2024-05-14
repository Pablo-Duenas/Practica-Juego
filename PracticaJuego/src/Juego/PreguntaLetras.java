package Juego;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
/**
 * La clase PreguntaLetras representa las preguntas de letras.
 *
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class PreguntaLetras extends Preguntas {
	Random aleatorio = new Random();
	private static String rutaFichero = "./Ficheros/diccionario.txt";
	private String palabraElegida;
	private String palabraOculta;
	
    /**
     * Crea una nueva instancia de PreguntaLetras, seleccionando una palabra aleatoria del diccionario
     * y ocultando algunas letras.
     */
	public PreguntaLetras() {
		palabraAleatoria();
		ocultarLetras();
	}
    /**
     * Coge una palabra aleatoria del diccionario.
     */
	public void palabraAleatoria() {
		try {
			Path rutaFicheroDiccionario = Paths.get(rutaFichero);
			List<String> palabras = Files.readAllLines(rutaFicheroDiccionario);
			if (!palabras.isEmpty()) {
				palabraElegida = palabras.get(aleatorio.nextInt(palabras.size()));
			} else {
				System.out.println("El diccionario está vacío.");
			}
		} catch (IOException excepcion) {
			System.out.println("Error al cargar el fichero diccionario.txt: " + excepcion.getMessage());
		}
	}
	   /**
     * Oculta algunas letras de la palabra elegida.
     */
	public void ocultarLetras() {
		StringBuilder palabraoculta = new StringBuilder();
		int numeroLetras = palabraElegida.length();
		int numeroLetrasOcultas;
		if (numeroLetras >= 3) {
			numeroLetrasOcultas = numeroLetras / 3;
		} else {
			numeroLetrasOcultas = 0;
		}
		for (int contador = 0; contador < numeroLetras; contador++) {
			if (numeroLetrasOcultas > 0 && (contador + 1) % 3 == 0) {
				palabraoculta.append('*');
				numeroLetrasOcultas--;
			} else {
				palabraoculta.append(palabraElegida.charAt(contador));
			}
		}

		palabraOculta = palabraoculta.toString();
	}
	/**
     * Comprueba si la palabra ingresada por el jugador es correcta.
     *
     * @param palabra La palabra ingresada por el jugador.
     * @return true si la palabra es correcta, false si la palabra es incorrecta.
     */
	public boolean palabraCorrecta(String palabra) {

		if (palabra.equalsIgnoreCase(palabraElegida)) {
			System.out.println("Enhorabuena esa es la palabra correcta");
			return true;
		} else {
			System.out.println("La palabra es incorrecta");
			System.out.println("La palabra correcta es: " + palabraElegida);
			return false;
		}
	}

	public String getPalabraElegida() {
		return palabraElegida;
	}

	public String getPalabraOculta() {
		return palabraOculta;
	}
    /**
     * Genera una solución para la máquina.
     *
     * @return La solución generada para la máquina.
     */
	public String solucionLetrasMaquina() {
		String solucion = "";
		return solucion;
		
	}
	
}
