package Juego;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Historico {

	private static String rutaFichero = "./Ficheros/Historico.txt";

	static void crearFicheroHistorico() {

		Path rutaFicheroHistorico = Paths.get(rutaFichero);

		if (!Files.exists(rutaFicheroHistorico)) {
			System.out.println("No tienes el fichero te lo creo yo");
			try {
				Files.createFile(rutaFicheroHistorico);

			} catch (IOException excepcion) {
				excepcion.printStackTrace();
			}

		}

	}

	public static void guardarpartida() {

		try (BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(rutaFichero, true))) {

			ArrayList<Jugador> jugadores = Jugador.listaJugadoresPartida();
			for (Jugador jugador : jugadores) {
				escribirFichero.write(jugador.getNombre() + " puntos: " + jugador.getPuntuacion() + " | ");
			}
			System.out.println("Registrando Partida....");

			escribirFichero.newLine();
		} catch (IOException excepcion) {
			throw new RuntimeException("Error al registrar la partida el archivo : " + excepcion);
		}
	}

	public static void mostrarFichero() {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));

			for (String linea : lineas) {
				System.out.println(linea);
			}
		} catch (NoSuchFileException excepcion) {
			System.err.println("Ese fichero no existe");
		} catch (FileSystemException e) {
			System.err.println("Excepcion de sistema de ficheros " + e);
		} catch (IOException e) {
			System.err.println("Excepcion generica al consultar el fichero " + e);
		}
	}

}
