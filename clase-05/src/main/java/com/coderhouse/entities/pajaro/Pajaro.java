package com.coderhouse.entities.pajaro;

import com.coderhouse.entities.Mascota;

public class Pajaro extends Mascota {
	
	private int alas;
	
	public int getAlas() {
		return alas;
	}

	public void setAlas(int alas) {
		this.alas = alas;
	}

	public void volar() {
		System.out.println(getNombre() + " esta volando!");
	};
	
	@Override
	public String toString() {
		return "Pajaro [Nombre= " + getNombre() + ", Color= " + getColor() + ", Raza= " + getRaza()
				+ ", Tamanio= " + getTamanio() + ", Edad= " + getEdad() + "]";
	}	
}
