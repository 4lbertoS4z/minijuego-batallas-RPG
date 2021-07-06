package modelo;

public class Geralt extends Personaje {
	//atributos
	public int pocionesTomadas;
	public String senial;//señal, malditas eñes
	public String senial1;


	//constructores
	public Geralt() {
		nOjos=2;
		nExtremidades=4;
		usaArma=true;
		profesion="Brujo";
		salud=100; 
		fuerza=20;
		pocionesTomadas=0;
		senial="Aard";
		senial1="Igni";
	}

	public Geralt(int nOjos, int nExtremidades, boolean usaArma, String profesion, int salud, int fuerza,
			int pocionesTomadas, String senial, String senial1) {
		super(nOjos, nExtremidades, usaArma, profesion, salud, fuerza);
		this.pocionesTomadas=pocionesTomadas;
		this.senial=senial;
		this.senial1=senial1;

	}



	public int getPocionesTomadas() {
		return pocionesTomadas;
	}

	public void setPocionesTomadas(int pocionesTomadas) {
		this.pocionesTomadas = pocionesTomadas;
	}
	//Metodos
	public void tomarPocion() {

		pocionesTomadas++;

		if (pocionesTomadas<=3) {// cura 40 puntos de salud
			salud+=40;
		}

		if (salud>100) {// si la salud es igual a la salud maxima de Geralt al curar se mantiene la salud maxima.
			salud=100;
		}

	}

	public void aard (Monstruo miMonstruo) {
		fuerza=rnd.nextInt(5)+28;//daño aleatorio entre 28 y 32
		miMonstruo.herir(fuerza);
	}

	public void igni (Monstruo miMonstruo) {// metodo que al recibir un valor de daño se lo resta a salud
		fuerza=rnd.nextInt(11)+15;
		miMonstruo.herir(fuerza);
	}

	public void pelear(int opcion, Monstruo miMonstruo) {
		switch (opcion) {
		case 1:
			fuerza=20;
			miMonstruo.herir(fuerza);
			break;
		case 2:
			aard(miMonstruo);
			break;
		case 3:
			igni(miMonstruo);
			break;
		case 4:
			tomarPocion();
			break;

		}

	}

	public void herir (int damage) {// metodo que al recibir un valor de daño se lo resta a salud
		salud-=damage;
	}


}