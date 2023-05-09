package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import controller.InicioListener;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class VInicio extends JFrame {

	public static final int ANCHO = 700;
	public static final int ALTO = 500;
	public static final String CONSULTAR_LISTA = "Consultar skaters";
	public static final String ANADIR_SKATER = "Añadir skater";
	public static final String SALIR = "Salir";
	public static final String INICIO = "Inicio";
	private JPanel contentPane;
	private JMenuItem mntmOpcion1;
	private JMenuItem mntmOpcion2;
	private JMenuItem mntmOpcion3;
	private JSeparator separator_1;

	private JSeparator separator_2;
	private JMenuItem mntmOpcion4;
	private JSeparator separator;
	private JScrollPane scrpContenedor;
	private JLabel lblSkateOrDie;

	public VInicio() {
		super("VIVA LOS SKATERS!!!!!!!!!!");
		setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));

		configurarMenu();

		init();
	}

	private void init() {

		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 686, 442);
		getContentPane().add(scrpContenedor);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setSize(ANCHO, ALTO);
		centrarVentana();
	}

	private void centrarVentana() {
		// TODO Auto-generated method stub
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Crear un objeto de tipo Dimension con las medidas en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}

	private void configurarMenu() {
		// TODO Auto-generated method stub
		JMenuBar mnbBarraMenu = new JMenuBar();
		mnbBarraMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		setJMenuBar(mnbBarraMenu);

		JMenu mnMenu1 = new JMenu("Menú");
		mnMenu1.setFont(new Font("Arial", Font.BOLD, 12));
		mnbBarraMenu.add(mnMenu1);

		mntmOpcion4 = new JMenuItem(INICIO);
		mntmOpcion4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcion4.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcion4);

		separator = new JSeparator();

		mnMenu1.add(separator);
		mntmOpcion1 = new JMenuItem(ANADIR_SKATER);
		mntmOpcion1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcion1.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcion1);

		separator_1 = new JSeparator();
		mnMenu1.add(separator_1);

		mntmOpcion2 = new JMenuItem(CONSULTAR_LISTA);
		mntmOpcion2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcion2.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcion2);

		separator_2 = new JSeparator();
		mnMenu1.add(separator_2);

		mntmOpcion3 = new JMenuItem(SALIR);
		mntmOpcion3.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcion3.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcion3);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		lblSkateOrDie = new JLabel("Skate or die");
		lblSkateOrDie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkateOrDie.setFont(new Font("Arial", Font.BOLD, 24));
		lblSkateOrDie.setBounds(147, 71, 359, 191);
		getContentPane().add(lblSkateOrDie);
	}

	public void hacerVisible() {
		setVisible(true);

	}

	public void setListener(InicioListener l) {
		mntmOpcion1.addActionListener(l);
		mntmOpcion2.addActionListener(l);
		mntmOpcion3.addActionListener(l);
		mntmOpcion4.addActionListener(l);

	}
	

	public void cargarPanel(JPanel panel) {
		// TODO Auto-generated method stub
		lblSkateOrDie.setText("");
		scrpContenedor.setViewportView(panel);
	}

	public void cargarPanel(VInicio inicio2) {

		// TODO Auto-generated method stub
		lblSkateOrDie.setText("Skate or die");
		scrpContenedor.setViewportView(contentPane);
	}

}