package modelo;

public class Jaskier extends Personaje{

	//Atributos
	public String intrumento;
	public String cancion;

	//constructor

	public Jaskier() {
		nOjos=2;
		nExtremidades=4;
		usaArma=true;
		profesion="Bardo";
		salud=80; 
		fuerza=10;
		intrumento="Laud";
		cancion="Cantar";
	}

	public Jaskier(int nOjos, int nExtremidades, boolean usaArma, String profesion, int salud, int fuerza,
			String intrumento, String cancion) {
		super(nOjos, nExtremidades, usaArma, profesion, salud, fuerza);
		this.intrumento = intrumento;
		this.cancion = cancion;
	}

	//getters y setters

	public String getIntrumento() {
		return intrumento;
	}

	public void setIntrumento(String intrumento) {
		this.intrumento = intrumento;
	}

	public String getCancion() {
		return cancion;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}



	//implementación interfaz huida
	public boolean huir() { // metodo booleano que devuelve true en un porcentaje dado.

		return Math.random()<0.3;

	}
	//métodos
	public String cantar(Monstruo miMonstruo) { // metodo random que si devuelve 0 llama al metodo enfurecer del monstruo, sino le resta 3 de fuerza
		int probabilidad;
		String frase;

		probabilidad=rnd.nextInt(2);

		if (probabilidad==0) {
			miMonstruo.enfurecer();
			frase="El monstruo lo mira cabreado. ";
		} else {
			miMonstruo.setFuerza(miMonstruo.getFuerza()-3);
			frase="El monstruo se ha calmado. ";
		}

		return frase;
	}

	public String pelear(int opcion, Monstruo miMonstruo) {
		String frase="";

		switch (opcion) {
		case 1: 
			miMonstruo.herir(fuerza);
			break;
		case 2:
			frase=cantar(miMonstruo);
			break;
		}

		return frase;
	}

	public void herir (int damage) { // metodo que al recibir un valor de daño se lo resta a salud
		salud-=damage;
	}

}