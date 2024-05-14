package Juego;

import java.util.ArrayList;
import java.util.Objects;

public class Jugador {

	private String nombre;
	private int puntuacion;
	private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

	public Jugador(String nombre) {
		this.nombre = nombre;
		puntuacion = 0;
	}

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

	public boolean eliminarJugador(Jugador jugador) {
		if (listaJugadores.contains(jugador)) {
			System.out.println("El jugador: " + jugador.getNombre() + " se ha eliminado correctamente");
			return listaJugadores.remove(jugador);
		} else {
			System.out.println("El Jugador no se encuentra");
			return false;
		}
	}

	public static void comprobarJugador(String nombre) {
		boolean encontrado = false;
		for (Jugador jugador : listaJugadores) {
			if (jugador.getNombre().contains(nombre)) {
				System.out.println(jugador);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.println("No esta ese jugador: " + nombre);
		}

	}

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

	public static ArrayList<Jugador> listaJugadoresPartida() {
		return listaJugadores;
	}

	public void sumarPuntos() {
		puntuacion++;
	}

	public void mostrarPuntuacion() {
		System.out.println(nombre + ": " + "puntos: " + puntuacion);
	}

	public void mostrarJugadores() {
		for (Jugador jugador : listaJugadores) {
			System.out.println(jugador.getNombre());
		}
	}

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