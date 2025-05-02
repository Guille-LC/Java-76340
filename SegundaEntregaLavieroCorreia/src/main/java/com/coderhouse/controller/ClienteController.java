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

import com.coderhouse.models.Cliente;
import com.coderhouse.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	};
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId){
		try {
			if (clienteRepository.existsById(clienteId)) {
				Cliente cliente = clienteRepository.findById(clienteId).get();
				return ResponseEntity.ok(cliente); //200
			} else {
				return ResponseEntity.notFound().build(); //404
			}
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	}
	
	@PostMapping("/create")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	};
	
	
}
