package com.coderhouse;

import com.coderhouse.entities.erizo.Erizo;
import com.coderhouse.entities.gato.Gato;
import com.coderhouse.entities.pajaro.Pajaro;
import com.coderhouse.entities.perro.Perro;

public class Main {

	public static void main(String[] args) {
		
		Perro krypto = new Perro();
		krypto.setNombre("Krypto");
		krypto.setColor("Blanco");
		krypto.setRaza("Kryptoniana");
		krypto.setTamanio("Mediano");
		krypto.setEdad(5);
		krypto.setPatas(4);
		krypto.setEsDomestico(true);
		
		Gato felix = new Gato();
		felix.setNombre("Felix");
		felix.setColor("Blanco y negro");
		felix.setRaza("Smoking");
		felix.setTamanio("Pequeño");
		felix.setEdad(4);
		felix.setPatas(4);
		felix.setEsDomestico(true);
		
		Pajaro woody = new Pajaro();
		woody.setNombre("Woody Woodpecker");
		woody.setColor("Azul y rojo");
		woody.setRaza("Carpintero");
		woody.setTamanio("Mediano");
		woody.setEdad(10);
		woody.setAlas(2);
		woody.setPatas(2);
		woody.setEsDomestico(false);
		
		Erizo sonic = new Erizo();
		sonic.setNombre("Sonic the hedgehog");
		sonic.setColor("Azul");
		sonic.setRaza(null);
		sonic.setTamanio("Mediano");
		sonic.setEdad(10);
		sonic.setPatas(2);
		sonic.setEsDomestico(false);
		sonic.setVelocidadMaxima(1000);
		
	}

}
