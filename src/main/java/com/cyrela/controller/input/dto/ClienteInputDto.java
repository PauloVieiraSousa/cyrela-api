package com.cyrela.controller.input.dto;

import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cyrela.controller.output.dto.ClienteOutputDto;
import com.cyrela.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInputDto {
	
	@NotEmpty(message = "Campo name obrigatório")
	private String name;

	@NotNull(message = "Campo empreendimentoId obrigatório")
	private Long empreendimentoId;
	
	@NotNull(message = "Campo unidadeId obrigatório")
	private Long unidadeId;
	
	@NotNull(message = "Campo blocoId obrigatório")
	private Long blocoId;
	
	@NotNull(message = "Campo dataGarantia obrigatório")
	private Instant dataGarantia;
	
}
