package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table (name = "Coches")
public class Concesionaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Marca", nullable = false)
	private String marca;
	@Column(name = "Modelo", nullable = false)
	private int modelo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "cliente_coche",
			joinColumns = @JoinColumn(name = "coche_id"),
			inverseJoinColumns = @JoinColumn(name = "cliente_id")
		)
	
	private List<Cliente> clientes = new ArrayList<>();
	
	public Concesionaria() {
		super();
	}
	
	public Concesionaria(String marca, int modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Concesionaria [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
