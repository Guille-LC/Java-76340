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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Controlador de clientes", description = "Endpoints para gestionar a los clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Operation(summary = "Obtener la lista de todos los clientes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de clientes", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@GetMapping(path = {"/",""})
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	};
	
	@Operation(summary = "Obtener el cliente por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente obtenido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
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
	
	@Operation(summary = "Crear cliente por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cliente creado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
	@PostMapping("/create")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {
			Cliente clienteNuevo = clienteService.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo); //201
		} catch(Exception error) {
			return ResponseEntity.internalServerError().build(); //500
		}
	}
	
	@Operation(summary = "Asigancion de cliente a coche")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "409", description = "Error al intentar asignar"),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
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
	
	@Operation(summary = "Actualizar cliente por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
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
	
	@Operation(summary = "Borrar cliente por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Cliente borrado", content = {@Content()}),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
	})
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
