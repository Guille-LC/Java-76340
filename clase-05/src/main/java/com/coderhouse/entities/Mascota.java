package com.coderhouse.entities;

public class Mascota {
	//Atributos

	private String nombre;
	private String color;
	private String raza;
	private String tamanio;
	private int edad;
	private int patas;
	private boolean esDomestico;
	
	//Metodos
	public void caminar() {
		System.out.println(getNombre() + " esta caminando.");	
	}
	public void comer() {
		System.out.println(getNombre() + " de color " + getColor() + " esta comiendo.");
	}

	//Getters y Setters
	public boolean isEsDomestico() {
		return esDomestico;
	}
	
	public void setEsDomestico(boolean esDomestico) {
		this.esDomestico = esDomestico;
	}
	
	public int getPatas() {
		return patas;
	}
	
	public void setPatas(int patas) {
		this.patas = patas;
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
	
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", color=" + color + ", raza=" + raza + ", tamanio=" + tamanio + ", edad="
				+"]";
	}
	
}
