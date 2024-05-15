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
/**
 * La clase Historico se encarga de gestionar el historial de partidas del juego.
 * Permite crear un archivo para almacenar el historial.
 * 
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class Historico {
	/** Ruta del archivo de Historico */
	private static String rutaFichero = "./Ficheros/Historico.txt";
	/**
     * Crea el archivo de historial si no existe.
     */
	public static void crearFicheroHistorico() {
		crearDirectorio();
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
	 /**
     * Registra los detalles de la partida actual en el archivo de historial.
     */
	public static void registrarPartida() {

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
	  /**
     * Muestra el contenido del archivo del historial.
     */
	public static void mostrarFichero() {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));

			for (String linea : lineas) {
				System.out.println(linea);
			}
		} catch (NoSuchFileException excepcion) {
			System.err.println("Ese fichero no existe");
		} catch (FileSystemException excepcion) {
			System.err.println("Excepcion de sistema de ficheros " + excepcion);
		} catch (IOException excepcion) {
			System.err.println("Excepcion generica al consultar el fichero " + excepcion);
		}
	}
	/**
     * Crea la carpeta donde se guardan los ficheros.
     */
	 public static void crearDirectorio(){

	        Path rutaCarpetaFicheros = Paths.get("Ficheros");
	        	if (!Files.exists(rutaCarpetaFicheros)) {
	        		try {
					
	        			Files.createDirectory(rutaCarpetaFicheros);
	        		} catch (IOException excepcion) {
	        			System.err.println("Error al crear directorio: " + rutaCarpetaFicheros );
				}
	        }
	    }

}
