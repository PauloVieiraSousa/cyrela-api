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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.cyrela.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;


@Api(value = "Cliente")
@AllArgsConstructor
@RequestMapping("api")
@RestController
public class ClienteController {
	

	private ClienteRepository clienteRepository;
	private EmpreendimentoRepository empreendimentoRepository;
	private BlocoRepository blocoRepository;
	private UnidadesRepository unidadesRepository;
	
	@ApiOperation(value = "Obtem lista de clientes cadastrados")
	@GetMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		
		return ResponseEntity.ok(clientes);
	}
	
	@ApiOperation(value = "Obtem os detalhes do cliente")
	@GetMapping(path = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteOutputDto getClienteDetail(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new ClienteOutputDto(cliente);
	}
	
	@ApiOperation(value = "Adiciona novo cliente")
	@PostMapping(path = "/clientes", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteOutputDto> addCliente(@RequestBody ClienteInputDto clienteDto, UriComponentsBuilder uriBuilder){
		
		Empreendimento empreendimento = empreendimentoRepository.getOne(clienteDto.getEmpreendimentoId());
		Bloco bloco = blocoRepository.getOne(clienteDto.getBlocoId());
		Unidades unidades = unidadesRepository.getOne(clienteDto.getUnidadeId());

		Cliente cliente = new Cliente(clienteDto.getName(), clienteDto.getDataGarantia(), empreendimento, unidades, bloco);
		
		Cliente save = clienteRepository.save(cliente);
		URI path = uriBuilder.path("/clientes/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(path).body(new ClienteOutputDto(save));
	}

}
