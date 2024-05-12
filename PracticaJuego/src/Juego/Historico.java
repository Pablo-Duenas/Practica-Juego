package Juego;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Historico {

	private static String rutaFichero = "./Ficheros/Historico.txt";
	
	
	
	static void crearFicheroHistorico() {

		Path rutaFichero1 = Paths.get(rutaFichero);

		if (!Files.exists(rutaFichero1)) {
			System.out.println("No tienes el fichero te lo creo yo");
			try {
				Files.createFile(rutaFichero1);

			} catch (IOException excepcion) {
				excepcion.printStackTrace();
			}

		}

	}
	
    public static void guardarpartida(){

        try(BufferedWriter bufer = new BufferedWriter(new FileWriter(rutaFichero, true))){

            ArrayList<Jugador> jugadores = Partida.jugadores;
            for (Jugador jugador : jugadores) {
                bufer.write(jugador.getNombre() + " puntos: " + jugador.getPuntuacion() + " ");
                System.out.println("Nueva partida registrada en el archivo");
            }

            bufer.newLine();
        } catch (IOException excepcion) {
            throw new RuntimeException("Error al registrar la partida el archivo | "+excepcion);
        }
    }
	
	
	
	
	
	
}
