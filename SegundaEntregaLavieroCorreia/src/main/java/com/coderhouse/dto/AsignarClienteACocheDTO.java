package com.coderhouse.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de asigancion de cliente a uno o varios coches")
public class AsignarClienteACocheDTO {

	@Schema(description = "ID del cliente", example = "1")
	private Long clienteId;
	
	@Schema(description = "IDs de los coches", example = "[2,4,6]")
	private List<Long> cocheIds;
}
