package Juego;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * La clase Ranking realiza el ranking de jugadores.
 *
 * @version 1.0
 * @since 0.1
 * @author Pablo
 */
public class Ranking {
	/** La ruta del archivo donde se guarda el ranking. */
	private static String rutaFichero = "./Ficheros/Ranking.txt";
	/** Lista de jugadores en el ranking. */
    private static ArrayList<Jugador> ranking = Jugador.listaJugadoresPartida();
    /** Lista de jugadores en el ranking, excluyendo a los jugadores CPU. */
	private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    /**
     * Muestra el ranking de jugadores.
     */
	 public static void mostarRanking() {
	        for (Jugador jugador : ranking) {
	            if (!jugador.getNombre().startsWith("cpu")) {
	            	listaJugadores.add(jugador);
	            }
	        }

	        listaJugadores.sort((jugador1, jugador2) -> Integer.compare(jugador2.getPuntuacion(), jugador1.getPuntuacion()));

	        for (Jugador ranking : listaJugadores) {
	            System.out.println(ranking);
	        }
	    }
	 
	    /**
	     * Registra la partida en el ranking.
	     */
	    public static void registrarRanking(){
	        try (BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(rutaFichero))) {

	            for (Jugador jugador : ranking) {
	            	if (!jugador.getNombre().startsWith("cpu")) {
	            		escribirFichero.write(jugador.getNombre() + " | " + jugador.getPuntuacion() + " | ");
					}
	            	escribirFichero.newLine();						
	                }
	            System.out.println("Partida registrada en el Ranking ");
	            }catch (IOException excepcion) {
	            	throw new RuntimeException("Error al registrar la partida el archivo : " + excepcion);
				}
	        
	    }
	 
	    /**
	     * Crea el fichero del ranking si no existe.
	     */
	public static void crearFicheroRanking() {

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


}
