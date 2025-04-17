package com.coderhouse.entities.gato;

import com.coderhouse.entities.Mascota;

public class Gato extends Mascota {

	@Override
	public void caminar() {
		System.out.println(getNombre() + " esta caminando sobre los techos.");
	}

	@Override
	public void comer() {
		System.out.println(getNombre() + " esta comiendo desde su valija.");
	}

	public void maullar() {
		System.out.println(getNombre() + " esta maullando.");
	};
	
	@Override
	public String toString() {
		return "Gato [Nombre= " + getNombre() + ", Color= " + getColor() + ", Raza= " + getRaza()
				+ ", Tamanio= " + getTamanio() + ", Edad= " + getEdad() + "]";
	}
}
