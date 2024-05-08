package Juego;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PreguntaIngles extends Preguntas {
	Random aleatorio = new Random();
	private String pregunta;
    private String respuestaCorrecta;
    private static String rutaFichero = "./Ficheros/ingles.txt";


    public PreguntaIngles() {
        this.pregunta = "";
        this.respuestaCorrecta = "";
    }

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
	}

