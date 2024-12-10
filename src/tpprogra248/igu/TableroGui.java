package tpprogra248.igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tpprogra248.negocio.Juego2048;
import tpprogra248.negocio.Tablero;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

public class TableroGui extends JFrame implements KeyListener {
	private Juego2048 juego2048 = new Juego2048();
	private static final long serialVersionUID = 1L;
	private JPanel panelJuego;
	private JPanel panelCeldas;
	private JLabel lblPuntos;
	private static JLabel[][] lblTablero;
	private int filas = 4;
	private int columnas = 4;
	private JLabel lblAyuda;

	public TableroGui(String nombre) {
		juego2048.cargarUsuario(nombre);
		juego2048.iniciarPuntuacion();
		inicializarComponentesGraficos();	
		inicializarCeldas();
	}

	private void inicializarComponentesGraficos() {
		lblTablero = new JLabel[filas][columnas];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 780);

		panelJuego = new JPanel();
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setBackground(new Color(239, 222, 222));
		panelJuego.setBounds(0, 0, 494, 664);
		setContentPane(panelJuego);
		panelJuego.setLayout(null);

		JPanel panelPuntos = new JPanel();
		panelPuntos.setBackground(new Color(180, 155, 154));
		panelPuntos.setForeground(new Color(175, 95, 95));
		panelPuntos.setBounds(348, 22, 106, 74);
		panelJuego.add(panelPuntos);
		panelPuntos.setLayout(null);

		JLabel lblPuntaje = new JLabel("Puntos");
		lblPuntaje.setForeground(new Color(255, 255, 255));
		lblPuntaje.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblPuntaje.setBounds(27, 11, 66, 21);
		panelPuntos.add(lblPuntaje);

		lblPuntos = new JLabel("" + juego2048.obtenerPuntuacionUsuario());
		lblPuntos.setForeground(new Color(255, 255, 255));
		lblPuntos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setBounds(10, 32, 86, 42);
		panelPuntos.add(lblPuntos);

		JLabel lblNombre = new JLabel();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setText(juego2048.mostrarNombreDelUsuario());
		lblNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNombre.setBounds(183, 56, 155, 40);
		panelJuego.add(lblNombre);

		lblAyuda = new JLabel("");
		lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyuda.setBounds(0, 669, 494, 47);
		panelJuego.add(lblAyuda);
	}

	private void inicializarCeldas() {
		panelCeldas = new JPanel();
		panelCeldas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCeldas.setBounds(34, 109, 420, 544);
		panelJuego.add(panelCeldas);
		panelCeldas.setLayout(new GridLayout(0, 4, 0, 0));
		crearTablero(panelCeldas);

		JLabel text2048 = new JLabel("2048");
		text2048.setFont(new Font("Tahoma", Font.PLAIN, 61));
		text2048.setBounds(34, 22, 139, 74);
		panelJuego.add(text2048);

		JLabel lblNewLabel = new JLabel("Jugador:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(183, 22, 155, 22);
		panelJuego.add(lblNewLabel);

		iniciarTablero();	
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	private void crearTablero(JPanel panelCeldas) {
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				lblTablero[fila][columna] = new JLabel();
				lblTablero[fila][columna].setFont(new Font("Arial",Font.BOLD,44));
				lblTablero[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
				lblTablero[fila][columna].setBorder(new LineBorder(new Color(0, 0, 0), 1));
				panelCeldas.add(lblTablero[fila][columna]);
			}
		}
	}
	
	private void iniciarTablero() { 
		actualizarTablero();       
	}

	private void actualizarPuntuacionCartel() {
		int nuevaPuntuacion = juego2048.obtenerPuntuacionUsuario();
		lblPuntos.setText(String.valueOf(nuevaPuntuacion));
	}

	private void actualizarTablero() {
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				String valorCelda = juego2048.obtenerValorCelda(f, c);
				if (valorCelda.equals("0")) {
					lblTablero[f][c].setText(" ");
					lblTablero[f][c].setOpaque(false);
				} else {
					lblTablero[f][c].setText(valorCelda);
					int valor = Integer.parseInt(valorCelda);
					Color colorCasilla = obtenerColorCasilla(valor);
					lblTablero[f][c].setBackground(colorCasilla);
					lblTablero[f][c].setOpaque(true);
				}
			}
		}
		mostrarAyuda();
	}

	private Color obtenerColorCasilla(int valor) {
		switch (valor) {
		case 2:
			return new Color(0xEEE4DA);
		case 4:
			return new Color(0xEDE0C8);
		case 8:
			return new Color(0xF2B179);
		case 16:
			return new Color(0xF59563);
		case 32:
			return new Color(0xF67C5F);
		case 64:
			return new Color(0xF65E3B);
		case 128:
			return new Color(0xEDCF72);
		case 256:
			return new Color(0xEDCC61);
		case 512:
			return new Color(0xEDC850);
		case 1024:
			return new Color(0xEDC53F);
		case 2048:
			return new Color(0xEDC22E);
		default:
			return new Color(175, 97, 97);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (juego2048.Ganaste()) {
			ganastePantalla();
		}

		if(juego2048.detectarFinDelJuego()) {
			juego2048.ingresarDatoArchivo(juego2048.traerUsuario());
			perdistePantalla(juego2048.mostrarNombreDelUsuario());
			this.dispose();
		}

		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		String movimiento = String.valueOf(keyCode);
		System.out.println(movimiento);
		juego2048.moverCasilla(movimiento);
		juego2048.sumarPuntuacion();
		actualizarPuntuacionCartel();
		actualizarTablero();
	}

	private void ganastePantalla() {
		GanasteGUI pantallaGanaste = new GanasteGUI();
		pantallaGanaste.setVisible(true);
		pantallaGanaste.setLocationRelativeTo(null);
	}

	private void perdistePantalla(String nombreUsuario) {
		PerdisteGUI pantallaPerdiste = new PerdisteGUI(nombreUsuario);
		pantallaPerdiste.setVisible(true);
		pantallaPerdiste.setLocationRelativeTo(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	private void mostrarAyuda() {
		Tablero tablero=juego2048.traerTablero();
		ArrayList<String> direccionesSumables = tablero.dondeHayCeldasSumables();
		if(direccionesSumables.size()!=0) {
			lblAyuda.setText("Ayuda: " + direccionesSumables.get(1));
		}
		else {
			lblAyuda.setText("");
		}
	}
}
