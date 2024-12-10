package tpprogra248.negocio;

public class Usuario {
	String nombre;
	int puntuacion;
	public Usuario(String nombre, int puntuacion) {
		this.nombre=validarNombre(nombre);
		this.puntuacion=puntuacion;
	}
	public Usuario(String nombre) {
		
		this.nombre=validarNombre(nombre);
		this.puntuacion=0;
	}
	
	public String obtenerNombre() {
		return nombre;
	}

	public void iniciarPuntuacion() {
		puntuacion=0;
	}
	public int cargarPuntuacion(int puntos) {
	    return puntuacion = puntos;
	}
	public int obtenerPuntuacion() {			
		return puntuacion;
	}
	   private String validarNombre(String nombre) {
	        String patron = "^[a-zA-Z0-9]+$_";
	        if (nombre.matches(patron)) {
	            return nombre;
	        } else {
	            return nombre.replaceAll("[^a-zA-Z0-9]", "_");
	        }
	    }
}