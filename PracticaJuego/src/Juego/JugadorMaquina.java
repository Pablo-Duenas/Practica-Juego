package Juego;

import java.util.ArrayList;

public class JugadorMaquina extends Jugador {
	private static ArrayList<JugadorMaquina> listaCPU = new ArrayList<>();
	
    public JugadorMaquina(String nombre) {
		super(nombre);
	}

	
	   public static void anyadirCPU(int numCpu){
	        for (int contador = 0; contador < numCpu ; contador++){
	        	String cpu = "cpu" +contador;
	        	JugadorMaquina numJugadoresCPU = new JugadorMaquina(cpu);
	            listaCPU.add(numJugadoresCPU);
	        }
	    }
	
	
	
	
}
