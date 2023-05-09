package model;

public class Skater {

	private String nombre;
	private String apellidos;
	private int edad;
	private String pais;
	private String genero;
	public static final String[] PAISES = { "", "Albania", "Bélgica", "Bulgaria", "Croacia", "Dinamarca", "Eslovaquia",
			"Eslovenia", "Finlandia", "Grecia", "Hungría", "Italia", "Letonia", "Lituania", "Noruega", "Polonia",
			"Rumanía", "Serbia", "Suecia", "Suiza", "Ucrania", "España", "Francia", "Canadá", "Estados Unidos",
			"México", "Guatemala", "Costa Rica", "Panamá", "Colombia", "Brasil", "Argentina", "Chile", "Perú",
			"Ecuador", "Venezuela", "Bolivia", "Paraguay", "Uruguay", "Cuba", "República Dominicana", "Honduras",
			"El Salvador", "Afganistán", "Arabia Saudita", "Bangladesh", "Birmania (Myanmar)", "Camboya", "China",
			"Corea del Norte", "Corea del Sur", "Emiratos Árabes Unidos", "Filipinas", "India", "Indonesia", "Irak",
			"Irán", "Israel", "Japón", "Jordania", "Kazajistán", "Kuwait", "Laos", "Líbano", "Malasia", "Maldivas",
			"Mongolia", "Nepal", "Omán", "Pakistán", "Qatar", "Singapur", "Siria", "Sri Lanka", "Argelia", "Angola",
			"Benín", "Botsuana", "Burkina Faso", "Burundi", "Cabo Verde", "Camerún", "Chad", "Comoras", "Congo",
			"Costa de Marfil", "Djibouti", "Egipto", "Eritrea", "Etiopía", "Gabón", "Gambia", "Ghana", "Guinea",
			"Guinea-Bissau", "Kenia", "Lesoto", "Liberia", "Libia", "Madagascar", "Malawi", "Malí", "Marruecos",
			"Mauricio", "Mauritania", "Mozambique", "Namibia", "Níger", "Nigeria", "República Centroafricana", "Ruanda",
			"Santo Tomé y Príncipe", "Senegal", "Seychelles", "Sierra Leona", "Somalia", "Sudáfrica", "Sudán",
			"Sudán del Sur", "Swazilandia", "Tanzania", "Togo", "Túnez", "Uganda", "Yemen", "Zambia", "Zimbabue",
			"Australia", "Fiyi", "Islas Marshall", "Islas Salomón", "Kiribati", "Micronesia", "Nauru", "Nueva Zelanda",
			"Palaos", "Papúa Nueva Guinea", "Samoa", "Tonga", "Tuvalu", "Vanuatu", "Timor Oriental", };

	public Skater() {
	}

	public Skater(String nombre, String apellidos, int edad, String pais, String genero) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Skater [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", pais=" + pais
				+ ", genero=" + genero + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public String getPais() {
		return pais;
	}

	public String getGenero() {
		return genero;
	}

}
