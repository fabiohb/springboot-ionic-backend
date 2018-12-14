package com.fabiohb.cursos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiohb.cursos.cursomc.domain.Cliente;
import com.fabiohb.cursos.cursomc.services.ClienteService;

@RestController
@RequestMapping("/clientes")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Cliente> listar(@PathVariable Integer id) {
		Cliente cliente = service.buscar(id);
		
		return ResponseEntity.ok(cliente);
	}
}