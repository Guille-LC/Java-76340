package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dto.AsignarClienteACocheDTO;
import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Concesionaria;
import com.coderhouse.repository.ClienteRepository;
import com.coderhouse.repository.ConcesionariaRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements CrudInterface<Cliente, Long> {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El cliente no existe"));
	}

	@Override
	@Transactional
	public Cliente save(Cliente nuevoCliente) {
		return clienteRepository.save(nuevoCliente);
	}

	@Override
	@Transactional
	public Cliente update(Long id, Cliente clienteActualizado) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El cliente no existe"));
		
		if(clienteActualizado.getNombre() != null && !clienteActualizado.getNombre().isEmpty()) {
			cliente.setNombre(clienteActualizado.getNombre());
		}
		
		if(clienteActualizado.getApellido() != null && !clienteActualizado.getApellido().isEmpty()) {
			cliente.setApellido(clienteActualizado.getApellido());
		}
		
		if(clienteActualizado.getDni() != 0) {
			cliente.setDni(clienteActualizado.getDni());
		}
		
		if(clienteActualizado.getEdad() != 0) {
			cliente.setEdad(clienteActualizado.getEdad());
		}
		
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("El cliente no existe");
		} else {
			clienteRepository.deleteById(id);			
		}
	}

	@Transactional
	public Cliente asignarClienteACoche(AsignarClienteACocheDTO dto) {
		
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new IllegalArgumentException("El cliente no existe"));
		
		for(Long cocheId : dto.getCocheIds()) {
			Concesionaria coche = concesionariaRepository.findById(cocheId).orElseThrow(() -> new IllegalArgumentException("El coche no existe"));
			
			if (cliente.getCoches().contains(coche)) {
				throw new IllegalStateException("El cliente ya tiene ese coche");
			}
			
			cliente.getCoches().add(coche);
			coche.getClientes().add(cliente);
			
			concesionariaRepository.save(coche);
	    }
		
		
		
		return clienteRepository.save(cliente);
	};
}
