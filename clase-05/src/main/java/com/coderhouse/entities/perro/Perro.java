package com.coderhouse.entities.perro;

import com.coderhouse.entities.Mascota;

public class Perro extends Mascota {

	public void olfateando() {
		System.out.println(getNombre() + " esta olfateando");
	};
	
	@Override
	public String toString() {
		return "Perro [Nombre= " + getNombre() + ", Color= " + getColor() + ", Raza= " + getRaza()
				+ ", Tamanio= " + getTamanio() + ", Edad= " + getEdad() + "]";
	}

	
}
