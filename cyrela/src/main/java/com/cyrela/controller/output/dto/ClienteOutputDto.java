package com.cyrela.controller.output.dto;

import com.cyrela.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOutputDto {

	private Long id;
	private String name;
	private Long empreendimentoId;
	private Long unidadeId;
	private Long blocoId;
	
	public ClienteOutputDto (Cliente cliente){
		this(cliente.getId(), cliente.getName(), cliente.getEmpreendimento().getId(),  cliente.getUnidades().getId(), cliente.getUnidades().getId());
	}
}
