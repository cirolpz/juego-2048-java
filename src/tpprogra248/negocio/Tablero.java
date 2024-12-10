package tpprogra248.negocio;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
	private static int[][] tablero;
	private int totalValorTablero;
	private Random random;

	public Tablero() {
		tablero = new int[][]{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		};
		random = new Random();
		totalValorTablero=0;
		agregarNuevoNum();
	}

	public int generarRandom(int num) {
		return random.nextInt(num);
	}

	public void agregarNuevoNum() {
		if(!hayCeldasVacias()) {
			return;
		}
		boolean casillaOcupada = true;
		while (casillaOcupada) {
			int columna = generarPosicion();
			int fila = generarPosicion();
			int numGenerado = generarNumero();
			if (tablero[fila][columna] == 0) {
				tablero[fila][columna] = numGenerado;
				casillaOcupada = false;
			}
		}
	}

	private int generarNumero() {
		int num = generarRandom(10);
		return (num == 0) ? 4 : 2;
	}

	private int generarPosicion() {
		return generarRandom(4);
	}

	@Override
	public String toString() {
		StringBuilder numeros = new StringBuilder();
		for (int[] fila : tablero) {
			for (int numero : fila) {
				numeros.append(numero).append(" ");
			}
			numeros.append("\n");
		}
		return numeros.toString();
	}

	public String obtenerValorCelda(int fila, int columna) {
		return String.valueOf(tablero[fila][columna]);
	}

	public int[][] getTablero() {
		return tablero;
	}

	boolean hayCeldasSumables() {
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				int valorCeldaActual = tablero[fila][columna];

				if (columna > 0 && tablero[fila][columna - 1] == valorCeldaActual) {
					return true;
				}
				if (columna < tablero[fila].length - 1 && tablero[fila][columna + 1] == valorCeldaActual) {
					return true;
				}
				if (fila > 0 && tablero[fila - 1][columna] == valorCeldaActual) {
					return true;
				}
				if (fila < tablero.length - 1 && tablero[fila + 1][columna] == valorCeldaActual) {
					return true;
				}
			}
		}
		return false;
	}

	boolean hayCeldasVacias() {
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				if(tablero[fila][columna] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<String> dondeHayCeldasSumables() {
		ArrayList<String> direccionesSumables = new ArrayList<>();
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero.length; columna++) {
				int valorCeldaActual = tablero[fila][columna];
				if(valorCeldaActual!=0) {
					if (columna > 0 && tablero[fila][columna - 1] == valorCeldaActual) {
						direccionesSumables.add("Izquierda");
					}
					if (columna < tablero[fila].length - 1 && tablero[fila][columna + 1] == valorCeldaActual) {
						direccionesSumables.add("Derecha");
					}
					if (fila > 0 && tablero[fila - 1][columna] == valorCeldaActual) {
						direccionesSumables.add("Arriba");
					}
					if (fila < tablero.length - 1 && tablero[fila + 1][columna] == valorCeldaActual) {
						direccionesSumables.add("Abajo");
					}
				}
			}
		}
		return direccionesSumables;
	}

	public boolean Ganaste() {
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero.length; columna++) {
				if (tablero[fila][columna]==2048)
					return true;
			}
		}
		return false;
	}

	public void sumarTotal(int valorCelda) {
		totalValorTablero+=valorCelda;
	}
	public int tamanioTotalTablero(Tablero tablero) {
		return tamanioFilaTablero()+tamanioColumnaTablero();
	}

	public int tamanioFilaTablero() {
	    return tablero.length;
	}

	public int tamanioColumnaTablero() {
	    return tablero[0].length;
	}
	
	public int celda(int f, int c) {
		return tablero[f][c];
	}
	public int cambiarValor(int fila, int columna, int valor) {
		return tablero[fila][columna]=valor;
	}

	public int totalValorTablero() {
		return totalValorTablero;
	}


}