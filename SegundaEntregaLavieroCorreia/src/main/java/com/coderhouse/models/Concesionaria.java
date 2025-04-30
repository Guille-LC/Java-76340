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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Data
@NoArgsConstructor

@Entity
@Table (name = "Coches")
public class Concesionaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	@ManyToOne(fetch = FetchType.EAGER)
	private Gama gama;
	
	public Concesionaria(String marca, int modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
}
