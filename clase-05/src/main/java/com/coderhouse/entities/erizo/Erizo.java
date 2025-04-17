package com.coderhouse.entities.erizo;

import com.coderhouse.entities.Mascota;

public class Erizo extends Mascota {

	private double velocidadMaxima;
	
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public void correr() {
		System.out.println("Esta corriendo a " + velocidadMaxima + "!!!!");
	}

	@Override
	public String toString() {
		return "Erizo [velocidadMaxima=" + velocidadMaxima + "]";
	}
	
	
}
