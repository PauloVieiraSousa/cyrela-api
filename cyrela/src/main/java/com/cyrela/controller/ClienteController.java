package com.cyrela.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cyrela.controller.input.dto.ClienteInputDto;
import com.cyrela.controller.output.dto.ClienteOutputDto;
import com.cyrela.exceptions.ResourceNotFoundException;
import com.cyrela.model.Bloco;
import com.cyrela.model.Cliente;
import com.cyrela.model.Empreendimento;
import com.cyrela.model.Unidades;
import com.cyrela.repository.BlocoRepository;
import com.cyrela.repository.ClienteRepository;
import com.cyrela.repository.EmpreendimentoRepository;
import com.cyrela.repository.UnidadesRepository;
import com.cyrela.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("api")
@RestController
public class ClienteController {
	

	private ClienteRepository clienteRepository;
	private EmpreendimentoRepository empreendimentoRepository;
	private BlocoRepository blocoRepository;
	private UnidadesRepository unidadesRepository;
	
	@GetMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping(path = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteOutputDto getClienteDetail(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new ClienteOutputDto(cliente);
	}
	
	
	@PostMapping(path = "/clientes", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteOutputDto> addCliente(@RequestBody ClienteInputDto clienteDto, UriComponentsBuilder uriBuilder){
		
		Empreendimento empreendimento = empreendimentoRepository.getOne(clienteDto.getEmpreendimentoId());
		Bloco bloco = blocoRepository.getOne(clienteDto.getBlocoId());
		Unidades unidades = unidadesRepository.getOne(clienteDto.getUnidadeId());

		Cliente cliente = new Cliente(clienteDto.getName(), empreendimento, unidades, bloco);
		
		Cliente save = clienteRepository.save(cliente);
		URI path = uriBuilder.path("/clientes/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(path).body(new ClienteOutputDto(save));
	}

}
