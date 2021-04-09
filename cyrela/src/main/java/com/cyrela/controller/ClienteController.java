package com.cyrela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyrela.model.Cliente;
import com.cyrela.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("api")
@RestController
public class ClienteController {
	

	private ClienteRepository clienteRepository;
	
	@GetMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> exampleSchedule() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
	}

}
