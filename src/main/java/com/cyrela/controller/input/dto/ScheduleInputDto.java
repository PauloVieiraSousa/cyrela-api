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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInputDto {
	
	@NotEmpty(message = "Campo subject obrigatório")
	private String subject;
	
	@NotNull(message = "Campo clienteId obrigatório")
	private Long clienteId;
	
	@NotNull(message = "Campo dateInitial obrigatório")
	private Instant dateInitial;
	
	@NotNull(message = "Campo dateFinal obrigatório")
	private Instant dateFinal;
	
	
}
