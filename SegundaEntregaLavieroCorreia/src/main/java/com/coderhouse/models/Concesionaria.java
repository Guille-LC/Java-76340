package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Modelo de coche")
@Table (name = "Coches")
public class Concesionaria {
	
	@Schema(description = "ID del coche", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Schema(description = "Marca del coche", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ferrari")
	@Column(name = "Marca", nullable = false)
	private String marca;
	
	@Schema(description = "Modelo del coche", requiredMode = Schema.RequiredMode.REQUIRED, example = "1980")
	@Column(name = "Modelo", nullable = false)
	private int modelo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "cliente_coche",
			joinColumns = @JoinColumn(name = "coche_id"),
			inverseJoinColumns = @JoinColumn(name = "cliente_id")
		)
	
	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<>();

	@Schema(description = "Gama de los coches")
	@ManyToOne(fetch = FetchType.EAGER)
	private Gama gama;
	
	public Concesionaria(String marca, int modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
}
