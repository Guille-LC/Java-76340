package com.coderhouse;

import com.coderhouse.perro.Perro;

public class Clase04 {

	public static void main(String[] args) {
		Perro primerPerro = new Perro();
//		primerPerro.nombre = "Krypto";
//		primerPerro.raza = "Kryptoniana";
//		primerPerro.color = "Blanco";
//		primerPerro.tamanio = "Mediano";
//		primerPerro.edad = 5;
//		primerPerro.peso = 20;
//		primerPerro.ladrar();
//		primerPerro.comer();
//		primerPerro.volar();
		
		primerPerro.setNombre("Krypto");
		primerPerro.setRaza("Kryptoniana");
		primerPerro.setColor("Blanco");
		primerPerro.setTamanio("Mediano");
		primerPerro.setEdad(4);
		primerPerro.setPeso(20.00);
		
		System.out.println(primerPerro.getNombre());
		System.out.println(primerPerro.getEdad());
	}
	
	

}
