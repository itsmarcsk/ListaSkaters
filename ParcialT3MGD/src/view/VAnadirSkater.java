package view;

import javax.swing.JPanel;

import controller.InicioListener;
import model.ListaSkaters;
import model.Skater;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VAnadirSkater extends JPanel {
	//ventana para añadir skaters
	public ListaSkaters lS;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEdad;
	private JLabel lblPais;
	private JLabel lblGenero;
	private JComboBox<String> cmbPaises;
	private DefaultComboBoxModel<String> dcbm;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JSpinner spnEdad;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rBMujer;
	private JRadioButton rBHombre;
	private JButton btnAnadir;
	public static final String ANADIR = "Añadir";
	public static final String REINICIAR = "Reiniciar";
	private JButton btnReiniciar;
	public VAnadirSkater() {

		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		setSize(VInicio.ANCHO - 35, VInicio.ALTO - 15);
		setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNombre.setBounds(95, 64, 49, 14);
		add(lblNombre);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 11));
		lblApellidos.setBounds(95, 101, 49, 14);
		add(lblApellidos);

		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEdad.setBounds(95, 147, 49, 14);
		add(lblEdad);

		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPais.setBounds(95, 186, 49, 14);
		add(lblPais);

		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGenero.setBounds(95, 240, 49, 14);

		add(lblGenero);

		cmbPaises = new JComboBox<String>();
		cmbPaises.setBackground(new Color(255, 255, 255));
		cmbPaises.setFont(new Font("Arial", Font.PLAIN, 11));
		cmbPaises.setBounds(225, 182, 78, 22);
		dcbm = new DefaultComboBoxModel<String>(Skater.PAISES);
		cmbPaises.setModel(dcbm);
		add(cmbPaises);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombre.setBounds(225, 61, 224, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellidos.setBounds(225, 98, 224, 20);
		add(txtApellidos);
		txtApellidos.setColumns(10);

		spnEdad = new JSpinner();
		spnEdad.setFont(new Font("Arial", Font.PLAIN, 11));
		spnEdad.setBounds(225, 144, 41, 20);
		spnEdad.setModel(new SpinnerNumberModel(12, 1, 70, 1));
		add(spnEdad);

		rBHombre = new JRadioButton("Hombre");
		rBHombre.setFont(new Font("Arial", Font.PLAIN, 11));
		rBHombre.setSelected(true);
		buttonGroup.add(rBHombre);
		rBHombre.setBounds(225, 236, 111, 23);
		add(rBHombre);

		rBMujer = new JRadioButton("Mujer");
		rBMujer.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonGroup.add(rBMujer);
		rBMujer.setBounds(338, 236, 111, 23);
		add(rBMujer);

		btnAnadir = new JButton(ANADIR);
		btnAnadir.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAnadir.setBounds(228, 284, 89, 23);
		add(btnAnadir);
		
		btnReiniciar = new JButton(REINICIAR);
		btnReiniciar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnReiniciar.setBounds(337, 284, 89, 23);
		add(btnReiniciar);

	}

	public void reiniciar() {
		spnEdad.setValue(12);
		cmbPaises.setSelectedIndex(0);
		txtNombre.setText("");
		txtApellidos.setText("");
		reiniciarRBtn();

	}

	public void reiniciarRBtn() {
		rBHombre.setSelected(true);
		
	}

	public Skater getDatos() {
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		int edad = (int) spnEdad.getValue();
		String genero = "Hombre";
		String[] paises= Skater.PAISES;
		String pais = paises[cmbPaises.getSelectedIndex()];
		if (rBMujer.isSelected()) {
			genero = "Mujer";
		}
		
		return new Skater(nombre, apellidos, edad,pais , genero);

	}

	public void setListener(InicioListener l) {
		btnAnadir.addActionListener(l);
		cmbPaises.addActionListener(l);
		btnReiniciar.addActionListener(l);

	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
		
	}
}
