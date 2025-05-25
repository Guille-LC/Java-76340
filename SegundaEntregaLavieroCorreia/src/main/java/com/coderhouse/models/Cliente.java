package com.coderhouse.models;

import java.util.ArrayList;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "Clientes")
public class Cliente {
	
	@Schema(description = "ID del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dexter")
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Holland")
	@Column(name = "Apellido", nullable = false)
	private String apellido;
	
	@Schema(description = "DNI del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
	@Column(name = "D.N.I.", nullable = false, unique = true)
	private int dni;
	
	@Schema(description = "Edad del cliente", example = "50")
	@Column(name = "Edad")
	private int edad;
	
	@Schema(description = "Lista de clientes")
	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Concesionaria> coches = new ArrayList<>();

	public Cliente(String nombre, String apellido, int dni, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
	}
	
	
}
