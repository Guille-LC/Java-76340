package com.coderhouse;

import com.coderhouse.entities.gato.Gato;
import com.coderhouse.entities.perro.Perro;

public class Main {

	public static void main(String[] args) {
		
		Perro krypto = new Perro();
		krypto.setNombre("Krypto");
		krypto.setColor("Blanco");
		krypto.setRaza("Kryptoniana");
		krypto.setTamanio("Mediano");
		krypto.setEdad(5);
		System.out.println(krypto);
		
		Gato felix = new Gato();
		felix.setNombre("Felix");
		felix.setColor("Blanco y negro");
		felix.setRaza("Smoking");
		felix.setTamanio("Pequeño");
		felix.setEdad(4);
		System.out.println(felix);
		
	}

}
