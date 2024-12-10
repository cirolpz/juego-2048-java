package tpprogra248.negocio;

import java.util.HashMap;

public class Juego2048 {
	Tablero tablero = new Tablero();
	HistorialUsuarios historialUsr = new HistorialUsuarios();
	Usuario usuario;
	Controles controles;

	public void cargarUsuario(String nombre) {
		usuario = new Usuario(nombre);
		controles = new Controles(tablero);
	}

	public void cargarUsuario(String nombre, int puntuacion) { 
		usuario = new Usuario(nombre, puntuacion);
		controles = new Controles(tablero); 
	}

	public String mostrarNombreDelUsuario() {
		return usuario.obtenerNombre();
	}

	public Tablero iniciarTablero() {
		return tablero;
	}

	public String obtenerValorCelda(int fila, int columna) {
		return tablero.obtenerValorCelda(fila, columna);
	}

	public void moverCasilla(String movimiento) {
		controles.moverCasilla(movimiento);
	}

	public String mostrarTablero() {
		return tablero.toString();
	}

	public void iniciarPuntuacion() {
		usuario.iniciarPuntuacion();
	}

	public int obtenerPuntuacionUsuario() {
		return usuario.obtenerPuntuacion();
	}

	public void sumarPuntuacion() {
		usuario.cargarPuntuacion(tablero.totalValorTablero());
	}

	public void ingresarDatoArchivo(Usuario usuario) {
		historialUsr.ingresarDatoArchivo(usuario);
	}

	public int puntosASumar() {
		return tablero.totalValorTablero();
	}

	public HashMap<String, Integer> leerDatoArchivo() {
		return historialUsr.leerDatoArchivo();
	}

	public boolean detectarFinDelJuego() {
		return !tablero.hayCeldasSumables() && !tablero.hayCeldasVacias();
	}

	public Usuario traerUsuario() {
		return usuario;
	}

	public boolean Ganaste() {
		return tablero.Ganaste();
	}

	public Tablero traerTablero() {
		return tablero;
	}
}