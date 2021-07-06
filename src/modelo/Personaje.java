package modelo;

import java.util.Random;

public abstract class Personaje {

	static Random rnd = new Random();

	public int nOjos;
	public int nExtremidades;
	public boolean usaArma;
	public String profesion;
	public int salud;
	public int fuerza;

	//constructores

	public Personaje() {
		super();
	}


	public Personaje(int nOjos, int nExtremidades, boolean usaArma, String profesion, int salud, int fuerza) {
		super();
		this.nOjos = nOjos;
		this.nExtremidades = nExtremidades;
		this.usaArma = usaArma;
		this.profesion = profesion;
		this.salud = salud;
		this.fuerza = fuerza;
	}


	//getters y setters

	public int getnOjos() {
		return nOjos;
	}



	public void setnOjos(int nOjos) {
		this.nOjos = nOjos;
	}



	public int getnExtremidades() {
		return nExtremidades;
	}



	public void setnExtremidades(int nExtremidades) {
		this.nExtremidades = nExtremidades;
	}



	public boolean isUsaArma() {
		return usaArma;
	}



	public void setUsaArma(boolean usaArma) {
		this.usaArma = usaArma;
	}



	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



	public int getSalud() {
		return salud;
	}



	public void setSalud(int salud) {
		this.salud = salud;
	}



	public int getFuerza() {
		return fuerza;
	}



	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	//interface

	public interface probabilidadHuida {
		public void huir();
		
	}







}

