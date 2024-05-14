package Juego;

import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * La clase PreguntaIngles representa las preguntas de inglés.
 *
 * @version 1.0
 * @since 0.1
 * @autor Pablo
 */
public class PreguntaIngles extends Preguntas {
	Random aleatorio = new Random();
	private String pregunta;
    private String respuestaCorrecta;
    private static String rutaFichero = "./Ficheros/ingles.txt";

    /**
     * Crea una nueva instancia de PreguntaIngles.
     */
    public PreguntaIngles() {
		this.pregunta = "";
		this.respuestaCorrecta = "";
	}


    /**
     * Muestra una pregunta aleatoria en inglés del archivo de preguntas.
     */
    public void mostrarPregunta() {
        try {
            Path rutaFicheroIngles = Paths.get(rutaFichero);
            List<String> preguntas = Files.readAllLines(rutaFicheroIngles);
            int lineas = aleatorio.nextInt(preguntas.size() / 5);
            
            pregunta = preguntas.get(lineas * 5);
            respuestaCorrecta = preguntas.get(lineas * 5 + 1);
            List<String> opciones = new ArrayList<>();
            opciones.addAll(preguntas.subList(lineas * 5 + 2, (lineas + 1) * 5));
            opciones.add(respuestaCorrecta);
            
            Collections.shuffle(opciones);
            
            System.out.println(pregunta);
            char letra = 'A';
            for (String opcion : opciones) {
            	if (respuestaCorrecta == opcion) {
					respuestaCorrecta = letra + respuestaCorrecta;
				}
                System.out.println(letra + ") " + opcion);
                letra++;
				}
        } catch (IOException excepcion) {
            System.out.println("Error al cargar el fichero ingles.txt: " + excepcion.getMessage());
        }
    }
    /**
     * Comprueba si la opción del jugador es la respuesta correcta.
     *
     * @param opcionSeleccionada La opción seleccionada por el jugador.
     * @return true si la opción seleccionada es correcta, false si la opcion seleccionada es incorrecta.
     */
    public boolean comprobarRespuesta(char opcionSeleccionada) {
        opcionSeleccionada = Character.toUpperCase(opcionSeleccionada);
        char letraCorrecta = Character.toUpperCase(respuestaCorrecta.charAt(0));
        if (opcionSeleccionada == letraCorrecta) {
            System.out.println("La opción es correcta");
            return true;
        } else {
            System.out.println("La opción es incorrecta, la opcion correcta es : "+ letraCorrecta );
            return false;
        }
    }
    /**
     * Genera una solución aleatoria para la máquina.
     *
     * @return La letra correspondiente a la solución para la máquina.
     */
	public char solucionInglesMaquina(){
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

