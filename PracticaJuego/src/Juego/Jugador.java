package Juego;

import java.util.ArrayList;  
import java.util.Objects;

public class Jugador {

	private String nombre;
	private int puntuacion;
	private ArrayList<Jugador> listaJugadores ;
	
	
	

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		this.listaJugadores = new ArrayList<Jugador>();
	}

	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.listaJugadores = new ArrayList<Jugador>();
	}
	
	public boolean ayadirJugador(Jugador jugador) {
		
		if (listaJugadores.contains(jugador)) {
			System.out.println("Ya existe un Jugador con ese nombre.");
			return false;
		} else {
			listaJugadores.add(jugador);
			System.out.println("El jugador: " +jugador.getNombre()+ " se ha añadido correctamente");
			return true;
		}
	}
	public boolean eliminarJugador(Jugador jugador) {
		if(listaJugadores.contains(jugador)) {
			System.out.println("El jugador: " +jugador.getNombre()+ " se ha eliminado correctamente");
			return this.listaJugadores.remove(jugador);
		}else {
			System.out.println("El Jugador no se encuentra");
			return false;
		}
	}
	
	public void comprobarJugador(Jugador jugador) {
		if (jugador.getListaJugadores().equals(jugador)) {
			System.out.println("Este jugador ya esta registrado");
		}else {
			System.out.println("Este jugador no esta registrado");
		}
	}
	
	
	
	public void mostrarJugadores() {
		for (Jugador jugador : listaJugadores) {
			System.out.println(jugador.getNombre());
		}
	}
	
	public void imprimirJugador() {
		System.out.println(toString());
	}
	
	

	public ArrayList<Jugador> getListaJugadores() {
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
	public void incrementarPuntuacion() {
		puntuacion++;
	}
	@Override
	public String toString() {
		return "Jugador nombre: " + nombre + ", "
				+ "puntuacion: " + puntuacion;
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
