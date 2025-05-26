package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de asigancion de gama a un coche")
public class AsignacionGamaACocheDTO {

	@Schema(description = "ID del coche", example = "2")
	private Long cocheId;
	
	@Schema(description = "ID de la gama", example = "3")
	private Long gamaId;
}
