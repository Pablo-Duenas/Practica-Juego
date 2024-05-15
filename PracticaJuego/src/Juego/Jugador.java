package Juego;

import java.util.ArrayList; 
import java.util.Objects;
/**
 * La clase Jugador representa a un jugador en el juego.
 * 
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class Jugador {

	private String nombre;
	private int puntuacion;
	private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
	 /**
     * Crea un nuevo jugador con un nombre y una puntuacion.
     * 
     * @since 0.1
     * @param nombre El nombre del jugador.
     */
	public Jugador(String nombre) {
		this.nombre = nombre;
		puntuacion = 0;
	}
	/**
     * Añade un jugador a la lista de jugadores.
     * 
     * @since 0.3
     * @param jugador El jugador que quieres añadir.
     * @return true si se añade correctamente, false si ya existe un jugador con el mismo nombre.
     */
	public boolean ayadirJugadorHumano(Jugador jugador) {
		if (jugador.comprobarNombre() == true) {
			if (listaJugadores.contains(jugador)) {
				System.out.println("Ya existe un Jugador con ese nombre.");
				return false;
			} else {
				listaJugadores.add(jugador);
				System.out.println("El jugador: " + jugador.getNombre() + " se ha añadido correctamente");
				return true;
			}
		} else {
			return false;
		}
	}
	/**
     * Añade el jugador maquina a la lista de jugadores.
     * 
     * @since 0.3
     * @param jugador El jugador que quieres añadir.
     * @return true si se añade correctamente, false si ya existe un jugador con el mismo nombre.
     */
	public boolean ayadirJugador(Jugador jugador) {
		if (listaJugadores.contains(jugador)) {
			System.out.println("Ya existe un Jugador con ese nombre.");
			return false;
		} else {
			listaJugadores.add(jugador);
			System.out.println("El jugador: " + jugador.getNombre() + " se ha añadido correctamente");
			return true;
		}
	}
	/**
     * Elimina un jugador de la lista de jugadores.
     * 
     * @since 0.3
     * @param jugador El jugador que quieres eliminar.
     * @return true si se elimina correctamente, false si el jugador no se encuentra.
     */
	public boolean eliminarJugador(Jugador jugador) {
		if (listaJugadores.contains(jugador)) {
			System.out.println("El jugador: " + jugador.getNombre() + " se ha eliminado correctamente");
			return listaJugadores.remove(jugador);
		} else {
			System.out.println("El Jugador no se encuentra");
			return false;
		}
	}
	 /**
     * Comprueba si existe un jugador con el nombre que le digan.
     * 
     * @since 0.3
     * @param nombre El nombre del jugador que quieres buscar.
     */
	public static boolean comprobarJugador(String nombre) {
		boolean encontrado = false;
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().contains(nombre)) {
				System.out.println(jugador);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.println("El jugador: " +nombre + " no esta registrado");
		}
		return encontrado;

	}
	/**
     * Comprueba si el nombre del jugador solo contiene letras.
     * 
     * @since 0.3
     * @return true si el nombre es valido, false si contiene números.
     */
	public boolean comprobarNombre() {
		int contador = 0;
		while (contador < this.nombre.length()) {
			if (Character.isLetter(this.nombre.charAt(contador)) == false) {
				System.out.println("Nombre invadilo. No puede tener numeros ");
				return false;

			}

			contador++;
		}

		return true;

	}
	 /**
     * Devuelve la lista de jugadores.
     * 
     * @since 0.3
     * @return La lista de jugadores.
     */
	public static ArrayList<Jugador> listaJugadoresPartida() {
		return listaJugadores;
	}
    /**
     * @since 0.3
     * Incrementa la puntuacion.
     */
	public void sumarPuntos() {
		puntuacion++;
	}
	/**
	 * @since 0.3
     * Muestra la puntuacion del jugador.
     */
	public void mostrarPuntuacion() {
		System.out.println(nombre + ": " + "puntos: " + puntuacion);
	}
	   /**
	    * @since 0.3
     * Muestra los nombres de todos los jugadores.
     */
	public void mostrarJugadores() {
		for (Jugador jugador : listaJugadores) {
			 if (!jugador.getNombre().startsWith("cpu")){
                 System.out.println(jugador.getNombre());
             }

		}
	}
    /**
     * @since 0.3
     * Imprime la información del jugador.
     */
	public void imprimirJugador() {
		System.out.println(toString());
	}

	public static ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	@Override
	public String toString() {
		return "Jugador nombre: " + nombre + ", " + "puntuacion: " + puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}
}