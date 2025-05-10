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

@RestController
@RequestMapping("/api/gama")
public class GamaController {

	@Autowired
	private GamaService gamaService;
	
	@GetMapping
	public List<Gama> getAllGamas() {
		return gamaService.findAll();
	}
	
	@GetMapping("/{gamaId}")
	public ResponseEntity<Gama> getGamaById(@PathVariable Long gamaId) {
		try {
			Gama gama = gamaService.findById(gamaId);
			return ResponseEntity.ok(gama); //200
		} catch (IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404
		} catch (Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	};
	
	@PostMapping("/create")
	public ResponseEntity<Gama> createGama(@RequestBody Gama gama) {
		try {
			Gama gamaNueva = gamaService.save(gama);
			return ResponseEntity.status(HttpStatus.CREATED).body(gamaNueva); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500			
		}
	} 
	
	@PutMapping("/{gamaId}")
	public ResponseEntity<Gama> updateGamaById(@PathVariable Long gamaId, @RequestBody Gama gamaActualizada) {
		try {
			Gama gama = gamaService.update(gamaId, gamaActualizada);
			return ResponseEntity.ok(gama); //200
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	};
	
	@DeleteMapping("/{gamaId}")
	public ResponseEntity<Void> deleteGama(@PathVariable Long gamaId) {
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
