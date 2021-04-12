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
import com.cyrela.model.Item;
import com.cyrela.model.SubItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcorrenciaInputDto {
	
	private String bandeira;
	private String ambiente;
	private String description;
	private Instant dateSchedule;
	private Long clienteId;
	private Long itemId;
	private Long subitemId;
	
	private Instant creationTime = Instant.now();


}
