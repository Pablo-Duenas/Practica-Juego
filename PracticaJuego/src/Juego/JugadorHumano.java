package Juego;

import java.util.ArrayList;

public class JugadorHumano extends Jugador {

	private static  ArrayList<JugadorHumano> listaJugadores = new ArrayList<JugadorHumano>();

	public JugadorHumano(String nombre) {
		super(nombre);
	}
	
	public static ArrayList<JugadorHumano> lista(){
		return listaJugadores;
		
	}
	
	

	public  boolean ayadirJugador(JugadorHumano jugador) {
		if (listaJugadores.contains(jugador)) {
			System.out.println("Ya existe un Jugador con ese nombre.");
			return false;
		} else {
			listaJugadores.add(jugador);
			System.out.println("El jugador: " + jugador.getNombre() + " se ha añadido correctamente");
			return true;
		}
	}

	public boolean eliminarJugador(JugadorHumano jugador) {
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
	            if(jugador.getNombre().contains(nombre)){
	                System.out.println("Jugador: " + jugador);
	                encontrado = true;
	            }
	        }
	        if (encontrado == false){
	            System.out.println("No esta ese jugador: " + nombre);
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

	public static ArrayList<JugadorHumano> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<JugadorHumano> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

}
