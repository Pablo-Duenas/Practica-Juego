package Juego;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PreguntaLetras extends Preguntas {
	Random aleatorio = new Random();
	private static String rutaFichero = "./Ficheros/diccionario.txt";
	private String palabraElegida;
	private String palabraOculta;
	
	
	public PreguntaLetras() {
		palabraAleatoria();
		ocultarLetras();
	}

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

}
