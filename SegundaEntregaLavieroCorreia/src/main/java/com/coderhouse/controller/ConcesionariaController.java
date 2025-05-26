package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.AsignacionGamaACocheDTO;
import com.coderhouse.models.Concesionaria;
import com.coderhouse.service.ConcesionariaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/coches")
@Tag(name = "Controlador de coches", description = "Endpoints para gestionar a los coches")
public class ConcesionariaController {

	@Autowired
	private ConcesionariaService concesionariaService;
	
	@Operation(summary = "Obtener la lista de todos los coches")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de coches", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Concesionaria.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@GetMapping(path = {"/",""})
	public List<Concesionaria> getAllCoches() {
		return concesionariaService.findAll();
	};
	
	@Operation(summary = "Obtener el coche por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Coche obtenido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Concesionaria.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@GetMapping("/{cocheId}")
	public ResponseEntity<?> getCocheById(@PathVariable Long cocheId) {
		if (cocheId == null) {
			return ResponseEntity.badRequest().body("¡El Id del coche no debe ser nulo!");
		}
		try {
			Concesionaria coche = concesionariaService.findById(cocheId);
			return ResponseEntity.ok(coche); //200
			} catch(IllegalArgumentException error) {
				return ResponseEntity.notFound().build(); //404
			} catch(Exception error) {
				return ResponseEntity.internalServerError().build(); //500
			}
		
	};
	
	@Operation(summary = "Crear coche por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Coche creado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Concesionaria.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PostMapping("/create")
	public ResponseEntity<Concesionaria> createCoche(@RequestBody Concesionaria coche) {
		try {
			Concesionaria cocheNuevo = concesionariaService.save(coche);
			return ResponseEntity.status(HttpStatus.CREATED).body(cocheNuevo); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500			
		}
	} 
	
	@Operation(summary = "Asigancion de gama a coche")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Coche actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Concesionaria.class))
			}),
			@ApiResponse(responseCode = "409", description = "Error al intentar asignar"),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PostMapping("/asignarGama")
	public ResponseEntity<?> asignarGamaACoche(@RequestBody AsignacionGamaACocheDTO dto){
		
		if (dto.getGamaId() == null || dto.getCocheId() == null) {
			return ResponseEntity.badRequest().body("¡Ningun Id de gama o de coche debe ser nulo!");
		}
		try {
			Concesionaria cocheActualizado = concesionariaService.asignarGamaACoche(
					dto.getCocheId(), dto.getGamaId()
					);
			return ResponseEntity.ok(cocheActualizado);
		} catch (IllegalStateException error) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage()); //409
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	}
	
	@Operation(summary = "Actualizar coche por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Coche actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Concesionaria.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PutMapping("/{cocheId}")
	public ResponseEntity<?> updateCocheById(@PathVariable Long cocheId, @RequestBody Concesionaria cocheActualizado) {
		if (cocheId == null) {
			return ResponseEntity.badRequest().body("¡El Id del coche no debe ser nulo!");
		}
		try {
			Concesionaria coche = concesionariaService.update(cocheId, cocheActualizado);
			return ResponseEntity.ok(coche); //200
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	}
	
	@Operation(summary = "Borrar coche por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Coche borrado", content = {@Content()}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@DeleteMapping("/{cocheId}")
	public ResponseEntity<?> deleteCoche(@PathVariable Long cocheId) {
		if (cocheId == null) {
			return ResponseEntity.badRequest().body("¡El Id del coche no debe ser nulo!");
		}
		try {
			concesionariaService.delete(cocheId);
			return ResponseEntity.noContent().build(); //204
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	}
	
}
