package Juego;

import java.util.Objects;

public class Jugador {

	private String nombre;
	private static int puntuacion = 0;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	public static void sumarPuntos() {
		puntuacion++;
    }

    public void mostrarPuntuacion() {
        System.out.println(nombre + ": " + "puntos: " + puntuacion );
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
