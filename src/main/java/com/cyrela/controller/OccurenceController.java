package com.cyrela.controller;


import java.net.URI;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cyrela.controller.input.dto.ClienteInputDto;
import com.cyrela.controller.input.dto.OcorrenciaInputDto;
import com.cyrela.controller.output.dto.ClienteOutputDto;
import com.cyrela.controller.output.dto.OcorrenciaTicketOutputDto;
import com.cyrela.controller.output.dto.ResponseOutput;
import com.cyrela.model.Bloco;
import com.cyrela.model.Cliente;
import com.cyrela.model.Empreendimento;
import com.cyrela.model.Item;
import com.cyrela.model.Ocorrencia;
import com.cyrela.model.SubItem;
import com.cyrela.model.Unidades;
import com.cyrela.repository.BlocoRepository;
import com.cyrela.repository.ClienteRepository;
import com.cyrela.repository.EmpreendimentoRepository;
import com.cyrela.repository.ItemRepository;
import com.cyrela.repository.OcorrenciaRepository;
import com.cyrela.repository.SubItemRepository;
import com.cyrela.repository.UnidadesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;


@Api(value = "Ocorrencia")
@AllArgsConstructor
@RequestMapping("api")
@RestController
public class OccurenceController {

	private OcorrenciaRepository ocorrenciaRepository;
	private ClienteRepository clienteRepository;
	private ItemRepository itemRepository;
	private SubItemRepository subItemRepository;
	
	
	@ApiOperation(value = "Obtem lista de ocorrencias cadastradas")
	@GetMapping(path = "/occurrence", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ocorrencia>> getListOccurrence() {
		List<Ocorrencia> listOcurrencys = ocorrenciaRepository.findAll();
		return listOcurrencys.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(listOcurrencys);
	}
	
	@ApiOperation(value = "Adiciona uma nova ocorrencia")
	@PostMapping(path = "/occurrence", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createOccurence(@Valid @RequestBody OcorrenciaInputDto ocorrenciaInputDto, UriComponentsBuilder uriBuilder){
		Cliente cliente = clienteRepository.getOne(ocorrenciaInputDto.getClienteId());
		
		if (cliente.getDateWarranty().isBefore(ocorrenciaInputDto.getCreationTime())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseOutput("Cliente fora da garantia"));
		}
		
		Item item = itemRepository.getOne(ocorrenciaInputDto.getItemId());
		SubItem subItem = subItemRepository.getOne(ocorrenciaInputDto.getSubitemId());
		
		Ocorrencia ocorrencia = new Ocorrencia(ocorrenciaInputDto.getBandeira(), ocorrenciaInputDto.getAmbiente(), ocorrenciaInputDto.getDescription(), ocorrenciaInputDto.getDateSchedule(), cliente, item, subItem);
		Ocorrencia save = ocorrenciaRepository.save(ocorrencia);
		URI path = uriBuilder.path("/occurrence/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(path).body(new OcorrenciaTicketOutputDto(save.getId()));
	}
	
	
	
	
}
