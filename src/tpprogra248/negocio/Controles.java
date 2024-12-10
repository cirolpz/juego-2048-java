package tpprogra248.negocio;

public class Controles {
	private Tablero tablero;
	public Controles(Tablero tabl) {
		tablero = tabl;
	}
	public void moverCasilla(String movimiento) {
		if(tablero.hayCeldasVacias() || tablero.hayCeldasSumables()) {
			if(movimiento.equals("40")||movimiento.equals("83")) {
				moverAbajo(tablero);
			}
			else if(movimiento.equals("38")||movimiento.equals("87")) {
				moverArriba(tablero);
			}
			else if(movimiento.equals("37")||movimiento.equals("65")) {
				moverIzquierda(tablero);
			}
			else if(movimiento.equals("39")||movimiento.equals("68")) {
				moverDerecha(tablero);
			}
		}
	}
	
	private void moverAbajo(Tablero tablero) {
		for (int c = 0; c < tablero.tamanioColumnaTablero(); c++) {
			for (int f = tablero.tamanioFilaTablero()-2; f >=0 ; f--) { //f=2
				if (tablero.celda(f,c) != 0) {
					int filaSig = f+1;
					while (filaSig < tablero.tamanioColumnaTablero() && (tablero.celda(filaSig,c) == 0 )) { //si la columna es >0 y si el num sgte es igual a 0
						tablero.cambiarValor(filaSig, c, tablero.celda(f,c));
						tablero.cambiarValor(f, c, 0);

						filaSig++;
						f++;
						tablero.sumarTotal(0);
					}
					if (filaSig < tablero.tamanioFilaTablero() && tablero.celda(f,c) == tablero.celda(filaSig,c)&&tablero.celda(filaSig,c) != 0) {
						tablero.cambiarValor(filaSig, c, tablero.celda(filaSig,c)*2);
						tablero.cambiarValor(f, c, 0);
						tablero.sumarTotal(tablero.celda(filaSig,c));
					}
				}
				else {
					tablero.sumarTotal(0);
				}
			}
		}
		tablero.agregarNuevoNum();
	}

	private void moverArriba(Tablero tablero) {
		for (int c = 0; c < tablero.tamanioColumnaTablero(); c++) {
			for (int f = 0; f < tablero.tamanioFilaTablero(); f++) {
				if (tablero.celda(f,c) != 0) {
					int actual = tablero.celda(f,c);
					int filaUlt = f-1;
					while (filaUlt >= 0 && (tablero.celda(filaUlt,c) == 0 )) {
						tablero.cambiarValor(filaUlt, c, actual);
						tablero.cambiarValor(f, c, 0);
						filaUlt--;
						f--;
						tablero.sumarTotal(0);
					} 
					if (filaUlt >= 0 && tablero.celda(f,c) == tablero.celda(filaUlt,c)&& (tablero.celda(filaUlt,c) != 0 )) {
						tablero.cambiarValor(filaUlt, c, tablero.celda(filaUlt,c)*2);
						tablero.cambiarValor(f, c, 0);
						tablero.sumarTotal(tablero.celda(filaUlt,c));
					}
				}
				else {
					tablero.sumarTotal(0);
				}
			}
		}
		tablero.agregarNuevoNum();
	}

	private void moverIzquierda(Tablero tablero) {
		for (int fila = 0; fila < tablero.tamanioFilaTablero(); fila++) {
			for (int columna = 1; columna < tablero.tamanioColumnaTablero(); columna++) {
				if (tablero.celda(fila,columna) != 0 ) { // Si el número actual no es cero
					int actual = tablero.celda(fila,columna);
					int columnaAnterior = columna - 1;
					while (columnaAnterior >= 0 &&(tablero.celda(fila,columnaAnterior) == 0)) { //mientras este dentro de la grilla y el num anterior sea ==0	                    
						tablero.cambiarValor(fila, columnaAnterior, actual);
						tablero.cambiarValor(fila, columna, 0);

						columna--;
						columnaAnterior--;
						tablero.sumarTotal(0);
					}
					if (columnaAnterior >= 0 && tablero.celda(fila,columnaAnterior) == actual&&(tablero.celda(fila,columnaAnterior) != 0)) {
						tablero.cambiarValor(fila, columnaAnterior, tablero.celda(fila,columnaAnterior)*2);
						tablero.cambiarValor(fila, columna, 0);		
						tablero.sumarTotal(tablero.celda(fila,columnaAnterior));
					}
				}
				else {
					tablero.sumarTotal(0);
				}
			}
		}
		tablero.agregarNuevoNum();
	}

	private void moverDerecha(Tablero tablero) {
		for (int f = tablero.tamanioFilaTablero()-1; f >=0 ; f--) {
			for (int c = tablero.tamanioColumnaTablero()-2; c >=0 ; c--) {
				if (tablero.celda(f,c) != 0) {
					int columSig = c+1;
					while (columSig < tablero.tamanioFilaTablero() && (tablero.celda(f,columSig) == 0 )) { //si la columna es >0 y si el num sgte es igual a 0
						tablero.cambiarValor(f, columSig, tablero.celda(f,c));
						tablero.cambiarValor(f, c, 0);
						columSig++;
						c++;
						tablero.sumarTotal(0);
					}
					if (columSig <= tablero.tamanioFilaTablero()-1 &&tablero.celda(f,c) == tablero.celda(f,columSig)&& (tablero.celda(f,columSig) != 0 )) {
						tablero.cambiarValor(f, columSig, tablero.celda(f,c));
						tablero.cambiarValor(f, columSig, tablero.celda(f,columSig)*2);						
						tablero.cambiarValor(f, c, 0);
						tablero.sumarTotal(tablero.celda(f, columSig));
					}
				}
				else {
					tablero.sumarTotal(0);
				}
			}
		}
		tablero.agregarNuevoNum();
	}
}

