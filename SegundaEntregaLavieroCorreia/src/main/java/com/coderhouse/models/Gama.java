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
	
	@Schema(description = "ID de la gama", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Schema(description = "Tipo de gama", requiredMode = Schema.RequiredMode.REQUIRED, example = "Media")
	@Column(name = "Tipo de gama", nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "gama" ,fetch = FetchType.EAGER)
	@JsonIgnore
	private List <Concesionaria> coches = new ArrayList<>();	
	
	public Gama(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}
