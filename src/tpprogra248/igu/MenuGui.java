package tpprogra248.igu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtNombre;
	JButton btnJugar;
	JButton btnPuntuaciones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGui window = new MenuGui();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
	}

	public MenuGui() {
		initialize();}

	private void initialize() {
		cargarFrame();
		JPanel panelMenu = panelDelMenu();
		generarLbl2048(panelMenu);
		generarLblNombre(panelMenu);
		generarTextNombre(panelMenu);
		generarBotones(panelMenu);
	}

	private void cargarFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private JPanel panelDelMenu() {
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(239, 222, 222));
		panelMenu.setBounds(-13, 0, 470, 243);
		frame.getContentPane().add(panelMenu);
		return panelMenu;
	}
	
	private void generarLbl2048(JPanel panelMenu) {
		JLabel lbl2048 = new JLabel("2048");
		lbl2048.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2048.setForeground(new Color(175, 97, 97));
		lbl2048.setFont(new Font("Segoe UI Semibold", Font.BOLD, 38));
		lbl2048.setBounds(184, 12, 99, 43);
		panelMenu.add(lbl2048);
	}

	private void generarLblNombre(JPanel panelMenu) {		
		JLabel lblNombre = new JLabel("Ingrese su nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(175, 97, 97));
		lblNombre.setBounds(175, 74, 126, 14);
		panelMenu.add(lblNombre);
	}

	private void generarTextNombre(JPanel panelMenu) {
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setColumns(10);
		txtNombre.setBounds(149, 94, 176, 20);
		panelMenu.add(txtNombre);
	}

	private void generarBotones(JPanel panelMenu) {
		crearBotonPuntuacion( panelMenu);
		crearBotonJugar( panelMenu);
		funcionBotonPuntuacion( panelMenu);
		funcionBotonJugar( panelMenu);
	}

	private void crearBotonPuntuacion(JPanel panelMenu) {
		btnPuntuaciones = new JButton("Puntuaciones");
		btnPuntuaciones.setBounds(171, 178, 136, 23);
		panelMenu.add(btnPuntuaciones);
	}
	
	private void crearBotonJugar(JPanel panelMenu) {
		btnJugar = new JButton("Nuevo Juego");
		btnJugar.setBounds(178, 137, 119, 23);
		panelMenu.add(btnJugar);
	}
	
	private void funcionBotonPuntuacion(JPanel panelMenu) {
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empezarJuego();
			}});
	}
	
	private void funcionBotonJugar(JPanel panelMenu) {
		btnPuntuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPuntuaciones();
			}});
	}

	private void mostrarPuntuaciones() {
		PuntuacionesGui tabPuntuacion  = new PuntuacionesGui();
		tabPuntuacion.setVisible(true);
		tabPuntuacion.setLocationRelativeTo(null);
	}

	private void empezarJuego() {
		if (txtNombre.getText().isEmpty()) {
			mostrarMensaje("Debes ingresar un nombre", "Error", "");
		}else {
			crearTableroGUI();
			frame.dispose();
		}
	}

	private void crearTableroGUI() {
		TableroGui pantallaJuego = new TableroGui(txtNombre.getText());
		pantallaJuego.setVisible(true);
		pantallaJuego.setLocationRelativeTo(null);
	}

	public void mostrarMensaje(String mensaje, String tipo, String titulo){
		JOptionPane optionPane = new JOptionPane(mensaje);
		if (tipo.equals("Info")){
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		}else if (tipo.equals("Error")) {
			optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
		}
		JDialog dialog = optionPane.createDialog(titulo);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
}