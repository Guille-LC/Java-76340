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

@RestController
@RequestMapping("/api/coches")
public class ConcesionariaController {

	@Autowired
	private ConcesionariaService concesionariaService;
	
	@GetMapping(path = {"/",""})
	public List<Concesionaria> getAllCoches() {
		return concesionariaService.findAll();
	};
	
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
	
	@PostMapping("/create")
	public ResponseEntity<Concesionaria> createCoche(@RequestBody Concesionaria coche) {
		try {
			Concesionaria cocheNuevo = concesionariaService.save(coche);
			return ResponseEntity.status(HttpStatus.CREATED).body(cocheNuevo); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500			
		}
	} 
	
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
