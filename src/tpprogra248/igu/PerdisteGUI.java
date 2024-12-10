package tpprogra248.igu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerdisteGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String nombre;

	public PerdisteGUI(String nombre) {
		this.nombre = nombre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPerdiste = new JLabel("PERDISTE");
        lblPerdiste.setForeground(Color.WHITE);
        lblPerdiste.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerdiste.setBounds(10, 27, 416, 73);
        contentPane.add(lblPerdiste);
        
        JButton btnNewButton = new JButton("Reintentar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		crearNuevoJuego();
        	}
        });
        
        btnNewButton.setBounds(162, 165, 108, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Finalizar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrar();
        	}
        });
        
        btnNewButton_1.setBounds(162, 195, 108, 23);
        contentPane.add(btnNewButton_1);
	}
	
	private void crearNuevoJuego() {
		TableroGui nuevoJuego = new TableroGui(nombre);
		nuevoJuego.setVisible(true);
		nuevoJuego.setLocationRelativeTo(null);
		this.dispose();
	}
	private void cerrar() {
		this.dispose();
	}
}
