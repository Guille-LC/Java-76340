package com.coderhouse.entities;

public class Mascota {
	private String nombre;
	private String color;
	private String raza;
	private String tamanio;
	private int edad;
	
	public void caminar() {
		System.out.println(getNombre() + " esta caminando.");	
	}
	
	public void comer() {
		System.out.println(getNombre() + " de color " + getColor() + " esta comiendo.");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
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
	
}
