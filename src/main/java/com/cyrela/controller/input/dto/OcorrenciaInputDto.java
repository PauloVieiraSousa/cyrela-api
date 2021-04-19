package com.cyrela.controller.input.dto;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cyrela.model.Cliente;
import com.cyrela.model.Item;
import com.cyrela.model.SubItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcorrenciaInputDto {
	
	@NotEmpty(message = "Campo bandeira obrigatório")
	private String bandeira;
	
	private String ambiente;
	
	@NotEmpty(message = "Campo description obrigatório")
	private String description;
	
	@NotNull(message = "Campo dateSchedule obrigatório")
	private Instant dateSchedule;
	
	@NotNull(message = "Campo clienteId obrigatório")
	private Long clienteId;
	
	@NotNull(message = "Campo itemId obrigatório")
	private Long itemId;
	
	@NotNull(message = "Campo subitemId obrigatório")
	private Long subitemId;
	
	private Instant creationTime = Instant.now();


}
