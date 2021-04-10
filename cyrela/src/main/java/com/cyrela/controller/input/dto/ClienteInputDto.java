package com.cyrela.controller.input.dto;

import com.cyrela.controller.output.dto.ClienteOutputDto;
import com.cyrela.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInputDto {
	
	private String name;
	private Long empreendimentoId;
	private Long unidadeId;
	private Long blocoId;
	
}
