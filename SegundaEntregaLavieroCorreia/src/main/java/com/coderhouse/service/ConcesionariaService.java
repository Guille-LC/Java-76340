package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Concesionaria;
import com.coderhouse.repository.ConcesionariaRepository;

import jakarta.transaction.Transactional;

@Service
public class ConcesionariaService implements CrudInterface<Concesionaria, Long> {

	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	@Override
	public List<Concesionaria> findAll() {
		return concesionariaRepository.findAll();
	}

	@Override
	public Concesionaria findById(Long id) {
		return concesionariaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El coche no existe"));
	}

	@Override
	@Transactional
	public Concesionaria save(Concesionaria nuevoCoche) {
		return concesionariaRepository.save(nuevoCoche);
	}

	@Override
	@Transactional
	public Concesionaria update(Long id, Concesionaria cocheActualizado) {
		
		Concesionaria coche = concesionariaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El coche no existe"));
		
		if(cocheActualizado.getMarca() != null && !cocheActualizado.getMarca().isEmpty()) {
			coche.setMarca(cocheActualizado.getMarca());
		}
		if(cocheActualizado.getModelo() != 0) {
			coche.setModelo(cocheActualizado.getModelo());
		}
		
		return concesionariaRepository.save(coche);
	}

	@Override
	public void delete(Long id) {
		if(!concesionariaRepository.existsById(id)) {
			throw new IllegalArgumentException("El coche no existe");
		} else {
			concesionariaRepository.deleteById(id);			
		}
	}

}
