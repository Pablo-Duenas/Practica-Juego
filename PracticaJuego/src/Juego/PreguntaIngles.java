package Juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PreguntaIngles extends Preguntas {
	Random aleatorio = new Random();
	private String respuestaCorrecta;
	private static String rutaFichero = "./Ficheros/ingles.txt";

	public PreguntaIngles() {
	}

	public void hacerPregunta() {
		try {
			Path rutaFicheroIngles = Paths.get(rutaFichero);
			List<String> lineas = Files.readAllLines(rutaFicheroIngles);
			 if (!lineas.isEmpty()) {
	                int numeroPregunta = aleatorio.nextInt(lineas.size() / 5);
	                int inicio = numeroPregunta * 5;
	                List<String> pregunta = lineas.subList(inicio, inicio + 5);
	                mostrarPregunta(pregunta);
			 }else {
				System.out.println("El archivo ingles.txt está vacío.");
			}
		} catch (IOException excepcion) {
			System.out.println("Error al cargar las preguntas del archivo ingles.txt: " + excepcion.getMessage());
		}

	}

	public void mostrarPregunta(List<String> lineas) {
		System.out.println("Pregunta de Ingles: " + lineas.get(0));
		respuestaCorrecta = lineas.get(1);
		List<String> opciones = new ArrayList<>();
		for (int i = 1; i < lineas.size(); i++) {
			opciones.add(lineas.get(i));
		}
		Collections.shuffle(opciones);
		System.out.println("Opciones:");
		char letra = 'a';
		for (String opcion : opciones) {
			System.out.println(letra + ") " + opcion);
			letra++;
		}
	}

}
