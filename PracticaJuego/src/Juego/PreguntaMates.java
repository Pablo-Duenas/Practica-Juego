package Juego;

import java.util.Iterator;
import java.util.Random;

public class PreguntaMates extends Preguntas {
	Random aleatorio = new Random();


	private int respuesta;

	public PreguntaMates(String pregunta, int respuesta) {
		super(pregunta);
		this.respuesta = respuesta;
	}

	
	
	public int generarExpresionMatematica() {
		int cantidadNumeros = aleatorio.nextInt(5) + 4;
		
		for (int contador = 0; contador != cantidadNumeros; contador++) {
			int valorNumero = aleatorio.nextInt(11)+ 2;
			int numero = valorNumero;
			System.out.println(numero);
		}
		
		
		return cantidadNumeros;
		
		
		
	}
	
	
}
