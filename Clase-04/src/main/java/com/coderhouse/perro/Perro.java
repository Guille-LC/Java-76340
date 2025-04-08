package com.coderhouse.perro;

public class Perro {
	//Atributos
	private String nombre;
	private String raza;
	private String color;
	private String tamanio;
	private int edad;
	private double peso;
	
	//Metodos
	public void ladrar() {
		System.out.println("Guau");
	};
	
	public void comer() {
		System.out.println("Esta comiendo");
	};
	
	public void volar() {
		System.out.println("Esta volando");
	}
	
	//Getter y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	};
	
	
}
