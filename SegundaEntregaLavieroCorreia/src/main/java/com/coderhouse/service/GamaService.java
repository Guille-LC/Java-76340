package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Gama;
import com.coderhouse.repository.GamaRepository;

import jakarta.transaction.Transactional;

@Service
public class GamaService implements CrudInterface<Gama, Long> {
	
	@Autowired
	private GamaRepository gamaRepository;

	@Override
	public List<Gama> findAll() {
		return gamaRepository.findAll();
	}

	@Override
	public Gama findById(Long id) {
		return gamaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La gama no existe"));
	}

	@Override
	@Transactional
	public Gama save(Gama nuevaGama) {
		return gamaRepository.save(nuevaGama);
	}

	@Override
	@Transactional
	public Gama update(Long id, Gama gamaActualizada) {
		Gama gama = gamaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La gama no existe"));
		
		if(gamaActualizada.getNombre() != null && !gamaActualizada.getNombre().isEmpty()) {
			gama.setNombre(gamaActualizada.getNombre());
		}
		
		return gamaRepository.save(gama);
	}

	@Override
	public void delete(Long id) {
		if(!gamaRepository.existsById(id)) {
			throw new IllegalArgumentException("La gama no existe");
		} else {
			gamaRepository.deleteById(id);
		}
		
	}

}
