package Juego;

import java.util.Random;

public class JugadorMaquina extends Jugador {

    public JugadorMaquina(String nombre) {
		super(nombre);
	}

	
	public int solucionMates(PreguntaMates pregunta) {
		int solucion = pregunta.getResultado();
		return solucion;
		
	}
	
	public String solucionLetras() {
		String solucion = "";
		return solucion;
		
	}
	
	public char solucionIngles(){
		Random aleatorio = new Random();
		char solucion= ' ';
		int letraSolucion = aleatorio.nextInt(4) + 1;
		if (letraSolucion == 1) {
			solucion = 'A';
		}else if (letraSolucion == 2) {
			solucion = 'B';
		}else if (letraSolucion == 3) {
			solucion = 'C';
		}else {
			solucion = 'D';
		}
		
		return solucion;
		
	}
	
	
}
