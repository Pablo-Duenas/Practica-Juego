package Juego;

import java.util.Random;  
import net.objecthunter.exp4j.ExpressionBuilder;
/**
 * La clase PreguntaMates representa las preguntas matemáticas.
 *
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class PreguntaMates extends Preguntas {
	Random aleatorio = new Random();
	StringBuilder operacion = new StringBuilder();

	private int resultado;
	private int cantidadNumeros;


	  /**
     * Genera una operación matemática aleatoria.
     */
	public void generarOperacion() {
		cantidadNumeros = aleatorio.nextInt(5) + 4;
		for (int contador = 0; contador < cantidadNumeros; contador++) {
			int numero = aleatorio.nextInt(11) + 2;
			operacion.append(numero);
			if (contador < cantidadNumeros - 1) {
				int signo = aleatorio.nextInt(3);
				if (signo == 0) {
					operacion.append(" * ");
				} else if (signo == 1) {
					operacion.append(" + ");
				} else {
					operacion.append(" - ");
				}
			}
		}
		String expresionMatematica = operacion.toString();
		System.out.println("Operacion: " + expresionMatematica);
		try {
			net.objecthunter.exp4j.Expression expresion = new ExpressionBuilder(expresionMatematica).build();
			resultado = (int) expresion.evaluate();
		} catch (Exception excepcion) {
			System.out.println("Error al evaluar la expresión: " + excepcion.getMessage());
		}
	}
	/**
     * Comprueba si el resultado ingresado por el jugador es correcto.
     *
     * @param resultadoUsuario El resultado ingresado por el jugador.
     * @return true si el resultado es correcto, false si el resultado es incorrecto.
     */
	public boolean comprobarResultado(int resultadoUsuario) {
		
			if (resultado == resultadoUsuario) {
				System.out.println("El resultado es correcto");
				return true;
			} else {
				System.out.println("El resultado es incorrecto, el resultado correcto es: " + resultado);
				return false;
			}
			

		

	}

	public int getResultado() {
		return resultado;
	}
    /**
     * Genera la solución para la máquina.
     *
     * @param pregunta La pregunta matemática.
     * @return La solución generada para la máquina.
     */
	public int solucionMatesMaquina(PreguntaMates pregunta) {
		int solucion = pregunta.getResultado();
		return solucion;
		
	}
	

}