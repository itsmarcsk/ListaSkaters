package view;

import javax.swing.JPanel;

import model.ListaSkaters;
import model.Skater;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.InicioListener;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VConsultarLista extends JPanel {
	//listado en una tabla, si se pulsa en alguna fila y se pulsa en el btnEliminar, se eliminará
	private JScrollPane scrpTabla;
	private DefaultTableModel model = new DefaultTableModel();
	public ArrayList<Skater> listaS = new ArrayList<>();
	private JTable table;
	public String[] column = new String[] { "Nombre", "Apellidos", "Edad", "País", "Género" };
	private JButton btnEliminar;
	public static final String ELIMINAR = "Eliminar";

	public VConsultarLista() {

		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		setSize(VInicio.ANCHO - 35, VInicio.ALTO - 15);
		setLayout(null);

		scrpTabla = new JScrollPane();
		scrpTabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTabla.setBounds(57, 55, 581, 285);
		add(scrpTabla);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setModel(model);

		scrpTabla.setViewportView(table);

		btnEliminar = new JButton(ELIMINAR);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEliminar.setBounds(533, 371, 89, 23);
		add(btnEliminar);

		configurarTabla();
		

	}

	public void configurarTabla() {
		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				/*
				 * if (column == 2) { return true; } else {
				 */
				return false;
				// }
			}

		};
		model.addColumn(column[0]);
		model.addColumn(column[1]);
		model.addColumn(column[2]);
		model.addColumn(column[3]);
		model.addColumn(column[4]);

		table.setModel(model);

	}

	public void rellenarTabla(ArrayList<Skater> ls) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[5];

		for (Skater skater : ls) {
			fila[0] = skater.getNombre();
			fila[1] = skater.getApellidos();
			fila[2] = skater.getEdad();
			fila[3] = skater.getPais();
			fila[4] = skater.getGenero();
			model.addRow(fila);
		}

	}

	public void setListener(InicioListener l) {
		btnEliminar.addActionListener(l);

	}

	public int obtenerElemSel() {
		return table.getSelectedRow();

	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
		
	}
}
