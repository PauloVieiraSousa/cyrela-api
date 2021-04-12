package com.cyrela.controller.input.dto;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cyrela.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInputDto {
	
	private String subject;
	private Long clienteId;
	private Instant dateInitial;
	private Instant dateFinal;
	
	
}
