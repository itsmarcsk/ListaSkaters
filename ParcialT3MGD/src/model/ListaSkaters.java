package model;

import java.util.ArrayList;

public class ListaSkaters {
	//lista de objetos, en este caso, el objeto es Skater
	private ArrayList<Skater> listaSkaters;

	public ListaSkaters() {

		listaSkaters = new ArrayList<>();
		cargarDatos();
	}
	//primera carga de datos para que el JTable tenga algun dato desde el principio
	private void cargarDatos() {
		listaSkaters.add(new Skater("Marc", "Giménez Díaz", 19, "España", "Hombre"));
		listaSkaters.add(new Skater("Nyjah", "Imani Huston", 28,"Suecia","Hombre"));
		listaSkaters.add(new Skater("Leticia", "Bufoni", 23,"Brasil", "Mujer"));
		listaSkaters.add(new Skater("Tony", "Hawk", 53, "Estados Unidos", "Hombre"));
		listaSkaters.add(new Skater("Paul", "Rodriguez", 38, "Estados Unidos", "Hombre"));
		listaSkaters.add(new Skater("Luan", "Oliveira", 31, "Brasil", "Hombre"));
		
	}
	//sirve para añadir objetos(skaters) a la lista
	public void addSkater(Skater s) {

		listaSkaters.add(s);
	}

	public ArrayList<Skater> getListaSkaters() {
		return listaSkaters;
	}

	public void setListaSkaters(ArrayList<Skater> listaSkaters) {
		this.listaSkaters = listaSkaters;
	}

	
	
}
