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

import com.coderhouse.models.Gama;
import com.coderhouse.service.GamaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/gama")
@Tag(name = "Controlador de las gamas", description = "Endpoints para gestionar a los distintos tipos de gamas")
public class GamaController {

	@Autowired
	private GamaService gamaService;
	
	@Operation(summary = "Obtener la lista de todas las gamas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de gamas", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Gama.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@GetMapping(path = {"/",""})
	public List<Gama> getAllGamas() {
		return gamaService.findAll();
	}
	
	@Operation(summary = "Obtener gama por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Gama obtenida", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Gama.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@GetMapping("/{gamaId}")
	public ResponseEntity<?> getGamaById(@PathVariable Long gamaId) {
		if (gamaId == null) {
			return ResponseEntity.badRequest().body("¡El Id de la gama no debe ser nulo!");
		}
		try {
			Gama gama = gamaService.findById(gamaId);
			return ResponseEntity.ok(gama); //200
		} catch (IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404
		} catch (Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	};
	
	@Operation(summary = "Crear gama por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Gama creado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Gama.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PostMapping("/create")
	public ResponseEntity<Gama> createGama(@RequestBody Gama gama) {
		try {
			Gama gamaNueva = gamaService.save(gama);
			return ResponseEntity.status(HttpStatus.CREATED).body(gamaNueva); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500			
		}
	} 
	
	@Operation(summary = "Actualizar gama por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Gama actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Gama.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PutMapping("/{gamaId}")
	public ResponseEntity<?> updateGamaById(@PathVariable Long gamaId, @RequestBody Gama gamaActualizada) {
		if (gamaId == null) {
			return ResponseEntity.badRequest().body("¡El Id de la gama no debe ser nulo!");
		}
		try {
			Gama gama = gamaService.update(gamaId, gamaActualizada);
			return ResponseEntity.ok(gama); //200
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	};
	
	@Operation(summary = "Borrar gama por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Gama borrada", content = {@Content()}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@DeleteMapping("/{gamaId}")
	public ResponseEntity<?> deleteGama(@PathVariable Long gamaId) {
		if (gamaId == null) {
			return ResponseEntity.badRequest().body("¡El Id de la gama no debe ser nulo!");
		}
		try {
			gamaService.delete(gamaId);
			return ResponseEntity.noContent().build(); //204
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	}
	
	
}
