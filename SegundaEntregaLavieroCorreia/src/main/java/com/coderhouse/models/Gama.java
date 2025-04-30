package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Tipo de gama")
public class Gama {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Tipo de gama", nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "coches" ,fetch = FetchType.EAGER)
	private List <Concesionaria> coche = new ArrayList<>();	
	
	public Gama(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}
