package modelo;


public class Yennefer extends Personaje{
	//atributos

	public String nombreHechizo;
	public String nombreHechizo1;
	public String nombreHechizo2;

	//constructores

	public Yennefer() {
		nOjos=2;
		nExtremidades=4;
		usaArma=true;
		profesion="Hechicera";
		salud=90; 
		fuerza=15;
		nombreHechizo="Piro++";
		nombreHechizo1="Aqua++";
		nombreHechizo2="Cura++";
	}

	public Yennefer(int nOjos, int nExtremidades, boolean usaArma, String profesion, int salud, int fuerza,
			String nombreHechizo, String nombreHechizo1, String nombreHechizo2) {
		super(nOjos, nExtremidades, usaArma, profesion, salud, fuerza);
		this.nombreHechizo = nombreHechizo;
		this.nombreHechizo1 = nombreHechizo1;
		this.nombreHechizo2 = nombreHechizo2;
	}

	//getters & setters

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}

	public String getNombreHechizo1() {
		return nombreHechizo1;
	}

	public void setNombreHechizo1(String nombreHechizo1) {
		this.nombreHechizo1 = nombreHechizo1;
	}

	public String getNombreHechizo2() {
		return nombreHechizo2;
	}

	public void setNombreHechizo2(String nombreHechizo2) {
		this.nombreHechizo2 = nombreHechizo2;
	}
	//metodos
	public void piro (Monstruo miMonstruo) {
		fuerza=rnd.nextInt(5)+28; //daño aleatorio entre 28 y 32
		miMonstruo.herir(fuerza);
	}

	public void aqua (Monstruo miMonstruo) {
		fuerza=rnd.nextInt(11)+15;//daño aleatorio entre 15 y 26
		miMonstruo.herir(fuerza);
	}

	public void cura () {
		salud+=50; // cura 50 puntos de salud

		if (salud>90) { // si la salud es igual a la salud maxima de Yennefer al curar se mantiene la salud maxima.
			salud=90;
		}

	}

	public void pelear(int opcion, Monstruo miMonstruo) {
		switch (opcion) {
		case 1:
			fuerza=15;
			miMonstruo.herir(fuerza);
			break;
		case 2:
			piro(miMonstruo);
			break;
		case 3:
			aqua(miMonstruo);
			break;
		case 4:
			cura();
			break;
		}

	}

	public void herir (int damage) { // metodo que al recibir un valor daño se lo resta a salud
		salud-=damage;
	}

}