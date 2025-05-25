package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Concesionaria;
import com.coderhouse.models.Gama;
import com.coderhouse.repository.ConcesionariaRepository;
import com.coderhouse.repository.GamaRepository;

import jakarta.transaction.Transactional;

@Service
public class ConcesionariaService implements CrudInterface<Concesionaria, Long> {

	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	@Autowired
	private GamaRepository gamaRepository;
	
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

	@Transactional
	public Concesionaria asignarGamaACoche(Long cocheId, Long gamaId) {
		Gama gama = gamaRepository.findById(gamaId).orElseThrow(() -> new IllegalArgumentException("La gama no existe"));
		Concesionaria coche = concesionariaRepository.findById(cocheId).orElseThrow(() -> new IllegalArgumentException("El coche no existe"));
		
		if (coche.getGama() != null && coche.getGama().getId().equals(gamaId)) {
			throw new IllegalStateException("El coche ya tiene esta gama asignada");
		}
		
		coche.setGama(gama);
		
		return concesionariaRepository.save(coche);
	};

}
