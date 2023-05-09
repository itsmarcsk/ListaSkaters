package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.ListaSkaters;
import model.Skater;
import view.VAnadirSkater;
import view.VConsultarLista;
import view.VInicio;

public class InicioListener implements ActionListener {

	private VInicio inicio;
	private VAnadirSkater anadir;
	private VConsultarLista consultaLista;
	private ListaSkaters lS;
	public InicioListener(VInicio inicio, VAnadirSkater anadir, VConsultarLista consultaLista) {
		this.inicio = inicio;
		this.anadir = anadir;
		this.consultaLista = consultaLista;
		lS = new ListaSkaters();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(VInicio.ANADIR_SKATER)) {
				inicio.cargarPanel(anadir);
			} else if (e.getActionCommand().equals(VInicio.CONSULTAR_LISTA)) {
				consultaLista.rellenarTabla(lS.getListaSkaters());
				inicio.cargarPanel(consultaLista);
			} else if (e.getActionCommand().equals(VInicio.INICIO)) {
				inicio.cargarPanel(inicio);
			} else if (e.getActionCommand().equals(VInicio.SALIR)) {
				System.exit(0);
			}		
		}else if (e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(VAnadirSkater.ANADIR)) {
				
				Skater skater = anadir.getDatos();
				if(skater.getNombre().equals("") || skater.getApellidos().equals("") || skater.getPais().equals("")) {
					consultaLista.mostrarError("Todos los campos son obligatorios");
				}else if(skater.getEdad()<12 || skater.getEdad()> 70) {
					consultaLista.mostrarError("La edad tiene que ser un número que se encuentre entre 12 y 70");
				}else {
					lS.addSkater(skater);
					anadir.reiniciar();
					anadir.mostrarMensaje("Se ha guardado con éxito");
				}
				
			}else if(e.getActionCommand().equals(VConsultarLista.ELIMINAR)) {
				int pos = consultaLista.obtenerElemSel();
				if (pos == -1) {
					consultaLista.mostrarError("Debe seleccionar un registro en la tabla");
				} else {
					int opcion = JOptionPane.showConfirmDialog(consultaLista, 
							"Se va a eliminar el registro seleccionado, ¿Desea continuar?", 
							"Confirmación",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					
					if (opcion == JOptionPane.YES_OPTION) {	
						ArrayList<Skater> list = new ArrayList<>();
						list = lS.getListaSkaters();
						list.remove(pos);
						lS.setListaSkaters(list);
						//lS.getListaSkaters().remove(pos);
						consultaLista.rellenarTabla(lS.getListaSkaters());
						consultaLista.mostrarMensaje("Se ha eliminado el registro seleccionado");
					}
				}
			}else if(e.getActionCommand().equals(VAnadirSkater.REINICIAR)) {
				Skater skater = anadir.getDatos();
				if(skater.getNombre().equals("") || skater.getApellidos().equals("") || skater.getPais().equals("") || skater.getEdad()==12 || skater.getGenero().equals("Hombre")) {
					anadir.mostrarError("No hay datos que modificar");
				}else {
					anadir.reiniciar();
					anadir.mostrarMensaje("Datos reiniciados");
				}
			}
			
		}
	}
}
