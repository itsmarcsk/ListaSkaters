package main;

import java.awt.EventQueue;

import controller.InicioListener;
import view.VAnadirSkater;
import view.VConsultarLista;
import view.VInicio;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VInicio inicio = new VInicio();
				VAnadirSkater anadirSkater = new VAnadirSkater();
				VConsultarLista consultarLista = new VConsultarLista();
				InicioListener iL = new InicioListener(inicio, anadirSkater, consultarLista);
				
				inicio.setListener(iL);
				anadirSkater.setListener(iL);
				consultarLista.setListener(iL);
				inicio.hacerVisible();
			}
		});
	}
}
