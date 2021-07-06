package modelo;


public class Monstruo extends Personaje {
	//atributos
	private String especie;

	//Constructores
	public Monstruo() {
		nOjos=2;
		nExtremidades=8;
		usaArma=true;
		profesion="Matar noobs";
		salud=200; 
		fuerza=20;
		especie="Kikimora";

	}

	public Monstruo(int nOjos, int nExtremidades, boolean usaArma, String profesion, int salud, int fuerza,
			String especie) {
		super(nOjos, nExtremidades, usaArma, profesion, salud, fuerza);
		this.especie = especie;


	}
	//getters &setters
	public String getEspecie() {
		return especie;
	}



	public void setEspecie(String especie) {
		this.especie = especie;
	}

	//implementación interfaz huida

	public boolean huir() {// metodo booleano que devuelve true en un porcentaje dado.

		return Math.random()<0.3;

	}
	//metodos
	public void herir (int damage) {// metodo que al recibir un valor de daño se lo resta a salud
		salud-=damage;
	}

	public void enfurecer() {// metodo que al ser enfurecio por el metodo cantar de jaskier le aumenta 10 puntos la fuerza al monstruo
		fuerza+=10;
	}

	public void pelear(Geralt miGeralt, Yennefer miYeni, Jaskier miJaskier) {

		miGeralt.herir(fuerza);

		miYeni.herir(fuerza);

		miJaskier.herir(fuerza);	

	}

}



