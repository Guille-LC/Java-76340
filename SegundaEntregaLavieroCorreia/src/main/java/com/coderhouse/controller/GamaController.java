package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Gama;
import com.coderhouse.repository.GamaRepository;

@RestController
@RequestMapping("/api/gama")
public class GamaController {

	@Autowired
	private GamaRepository gamaRepository;
	
	@GetMapping
	public List<Gama> getAllGamas() {
		return gamaRepository.findAll();
	}
	
	@GetMapping("/{gamaId}")
	public ResponseEntity<Gama> getGamaById(@PathVariable Long gamaId) {
		try {

			if(!gamaRepository.existsById(gamaId)) {
				return ResponseEntity.notFound().build();
			}
			Gama gama = gamaRepository.findById(gamaId).get();
			return ResponseEntity.ok(gama);
			
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build();
			
		}
	};
	
	@PostMapping("/create")
	public Gama createGama(@RequestBody Gama gama) {
		return gamaRepository.save(gama);
	} 
	
}
