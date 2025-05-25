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

import com.coderhouse.dto.AsignarClienteACocheDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(path = {"/",""})
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	};
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<?> getClienteById(@PathVariable Long clienteId){
		if (clienteId == null) {
			return ResponseEntity.badRequest().body("¡El Id del cliente no debe ser nulo!");
		}
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
	
	@PostMapping("/asignarClienteACoche")
	public ResponseEntity<?> asignarClienteACoche(@RequestBody AsignarClienteACocheDTO dto) {
		if (dto.getClienteId() == null || dto.getCocheIds() == null) {
			return ResponseEntity.badRequest().body("¡El Id del cliente o del coche no debe ser nulo!");
		}
		try {
			Cliente cliente = clienteService.asignarClienteACoche(dto);
			return ResponseEntity.ok(cliente); //200
		} catch (IllegalStateException error) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage()); //409
		} catch(IllegalArgumentException error) {
			return ResponseEntity.notFound().build(); //404	
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500		
		}
	};
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<?> updateClienteById(@PathVariable Long clienteId, @RequestBody Cliente clienteActualizado) {
		if (clienteId == null) {
			return ResponseEntity.badRequest().body("¡El Id del cliente no debe ser nulo!");
		}
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
	public ResponseEntity<?> deleteClienteById(@PathVariable Long clienteId) {
		if (clienteId == null) {
			return ResponseEntity.badRequest().body("¡El Id del cliente no debe ser nulo!");
		}
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
