package tpprogra248.igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GanasteGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public GanasteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGanaste = new JLabel("GANASTE");
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setForeground(Color.WHITE);
		lblGanaste.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblGanaste.setBounds(10, 34, 416, 73);
		contentPane.add(lblGanaste);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnNewButton_1.setBounds(154, 180, 108, 23);
		contentPane.add(btnNewButton_1);
	}
	
	private void cerrar() {
		this.dispose();
	}
}
