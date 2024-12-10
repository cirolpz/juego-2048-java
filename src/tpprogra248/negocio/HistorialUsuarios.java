package tpprogra248.negocio;
import java.io.*;
import java.util.*;

import java.io.IOException;

class HistorialUsuarios{
	public void ingresarDatoArchivo(Usuario usuario) {
		try {
			FileWriter escribir = new FileWriter("usuariosDate.txt",true);
			escribir.write("\n"+usuario.nombre+"-"+usuario.puntuacion);
			escribir.close();
		}catch(IOException excepcion){
			excepcion.printStackTrace(System.out);
		}
	}

	public HashMap<String, Integer> leerDatoArchivo() {
		HashMap<String, Integer> usuarios = new HashMap<>();
		try {
			FileReader archivoALeer = new FileReader("usuariosDate.txt");
			BufferedReader leer = new BufferedReader(archivoALeer);
			String contenido = leer.readLine();
			while (contenido != null) {
				String[] datos = obtenerDatosUsuario(contenido);
				if (datos != null) {
					usuarios.put(datos[0], Integer.parseInt(datos[1]));
				}
				contenido = leer.readLine();
			}
			leer.close();
		} catch (IOException excepcion) {
			excepcion.printStackTrace(System.out);
		}
		return usuarios;
	}

	private String[] obtenerDatosUsuario(String linea) {
		String nombre = "";
		String puntuacion = "";
		boolean esNombre = true;
		for (char caracter : linea.toCharArray()) {
			if (esNombre && caracter != '-') {
				nombre += caracter;
			} else {
				esNombre = false;
			}
			if (!esNombre && caracter != '-') {
				puntuacion += caracter;
			}
		}
		if (!puntuacion.isEmpty()) {
			return new String[]{nombre, puntuacion};
		} else {
			return null;
		}
	}
}


