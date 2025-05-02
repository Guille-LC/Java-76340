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

import com.coderhouse.models.Concesionaria;
import com.coderhouse.repository.ConcesionariaRepository;

@RestController
@RequestMapping("/api/coches")
public class ConcesionariaController {

	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	@GetMapping
	public List<Concesionaria> getAllCoches() {
		return concesionariaRepository.findAll();
	};
	
	@GetMapping("/{cocheId}")
	public ResponseEntity<Concesionaria> getCocheById(@PathVariable Long cocheId) {
		try {
			if(concesionariaRepository.existsById(cocheId)) {
				Concesionaria coche = concesionariaRepository.findById(cocheId).get();
				return ResponseEntity.ok(coche);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping("/create")
	public Concesionaria createCoche(@RequestBody Concesionaria coche) {
		return concesionariaRepository.save(coche);
	} 
}
