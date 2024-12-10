package tpprogra248.igu;

import java.awt.BorderLayout;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import tpprogra248.negocio.Juego2048;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class PuntuacionesGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablaPuntos;
    private Juego2048 juego2048 = new Juego2048();
	
    public PuntuacionesGui() {
        inicializarComponentes();
        cargarTabla();
    }

    private void inicializarComponentes() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 498, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        tablaPuntos = new JTable();
        tablaPuntos.setBounds(0, 0, 482, 509);
        panel.add(tablaPuntos);
    }
    
    private void cargarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
                return false;}
        };
        tablaDePuntuacion(modeloTabla);
        tablaPuntos.setModel(modeloTabla);
    }
    
    private void tablaDePuntuacion(DefaultTableModel modeloTabla) {
        String titulos[] = {"Nombre", "Puntos"};
        modeloTabla.setColumnIdentifiers(titulos);
        HashMap<String, Integer> listaDeUsuarios = juego2048.leerDatoArchivo();
        List<String> nombresUsuarios=listaUsuariosOrdenada(listaDeUsuarios,modeloTabla);
        modeloTabla.addRow(titulos);
        agregarListaUsuarios(modeloTabla, nombresUsuarios,  listaDeUsuarios);
    }
    
    private List<String> listaUsuariosOrdenada(HashMap<String, Integer> listaDeUsuarios,DefaultTableModel modeloTabla) {
        List<String> nombresUsuarios = new ArrayList<>(listaDeUsuarios.keySet());
        Collections.sort(nombresUsuarios, Comparator.comparingInt(listaDeUsuarios::get).reversed());
        return nombresUsuarios;
    }
    private void agregarListaUsuarios(DefaultTableModel modeloTabla,List<String> nombresUsuarios, HashMap<String, Integer> listaDeUsuarios ) {
    	   for (String nombre : nombresUsuarios) {
            modeloTabla.addRow(new Object[]{nombre, listaDeUsuarios.get(nombre)});
        }
    }
    
}