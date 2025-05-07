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

import com.coderhouse.models.Cliente;
import com.coderhouse.service.ClienteService;

@RestController // Se encarga de enviar y recibir las respuestas HTTP del cliente. Llama a los metodos del Service para devolver las respuestas.
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	};
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId){
		try {
			Cliente cliente = clienteService.findById(clienteId);
				return ResponseEntity.ok(cliente); //200
				
			} catch(IllegalArgumentException error) {				
				return ResponseEntity.notFound().build(); //404
				
			} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {
			Cliente clienteNuevo = clienteService.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> updateClienteById(@PathVariable Long clienteId, @RequestBody Cliente clienteActualizado) {
		try {
			Cliente cliente = clienteService.update(clienteId, clienteActualizado);
			return ResponseEntity.ok(cliente); //200
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
    }
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> deleteClienteById(@PathVariable Long clienteId) {
		try {
			clienteService.delete(clienteId);
			return ResponseEntity.noContent().build(); //204
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	}


}
