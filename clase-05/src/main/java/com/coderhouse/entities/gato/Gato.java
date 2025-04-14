package com.coderhouse.entities.gato;

import com.coderhouse.entities.Mascota;

public class Gato extends Mascota {

	@Override
	public String toString() {
		return "Gato [Nombre= " + getNombre() + ", Color= " + getColor() + ", Raza= " + getRaza()
				+ ", Tamanio= " + getTamanio() + ", Edad= " + getEdad() + "]";
	}
}
