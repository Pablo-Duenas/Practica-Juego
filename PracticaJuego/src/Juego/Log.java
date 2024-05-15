package Juego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * La clase Log gestiona todos los movimientos que hagas.
 *
 * @version 1.0
 * @since 0.1
 * @author pablo
 */
public class Log {
	   /** La ruta del archivo del Log. */
	private static String rutaFichero = "./Ficheros/Historico.txt";
	
    /**
     * Crea el archivo del Log si no existe.
     */
	public static void crearFicheroLog() {
		Path rutaFicheroLog = Paths.get(rutaFichero);
		
		if (!Files.exists(rutaFicheroLog)) {
			System.out.println("No tienes el fichero te lo creo yo");
			try {
				Files.createFile(rutaFicheroLog);

			} catch (IOException excepcion) {
				excepcion.printStackTrace();
			}

		}

	}
	
	
	
	
	
	
	
	
	
	
}
