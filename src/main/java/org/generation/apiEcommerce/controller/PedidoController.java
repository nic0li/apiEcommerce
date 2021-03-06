package org.generation.apiEcommerce.controller;

import java.util.List;

import org.generation.apiEcommerce.model.Pedido;
import org.generation.apiEcommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable long id) {
		return repository.findById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pedido> post (@RequestBody Pedido pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<Pedido> put (@RequestBody Pedido pedido) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pedido));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
