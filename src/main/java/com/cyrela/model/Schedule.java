package com.cyrela.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "agenda")
public class Schedule implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pjo_agendaid")
	private Long id;

	@Column(name = "pjo_subject")
	private String subject;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_clienteid", nullable = false)
	private Cliente cliente;
	
	
	@Column(name = "pjo_actualstart")
	private Instant dateInitial;
	
	@Column(name = "pjo_actualend")
	private Instant dateFinal;
	
	
	
	public Schedule(String subject, Instant dateInitial, Instant dateFinal, Cliente cliente) {
		this.subject = subject;
		this.dateInitial = dateInitial;
		this.dateFinal = dateFinal;
		this.cliente = cliente;
		
	}

	
	
}
