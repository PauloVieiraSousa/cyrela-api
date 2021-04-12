package com.cyrela.model;

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

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ocorrencia")
public class Ocorrencia {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pjo_ticketnumber")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_clienteid", nullable = false)
	private Cliente cliente;
	
	@Column(name = "pjo_bandeira")
	private String bandeira;
	
	@Column(name = "pjo_ambiente")
	private String ambiente;
	
	@Column(name = "pjo_description")
	private String description;
	
	@Column(name = "pjo_dataatendimento")
	private Instant dateSchedule;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_itemid", nullable = false)
	private Item item;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_subitemid", nullable = false)
	private SubItem subitem;
	
	
	public Ocorrencia(String bandeira, String ambiente, String description, Instant dateSchedule, Cliente cliente, Item item, SubItem subitem) {
		this.bandeira = bandeira;
		this.ambiente = ambiente;
		this.description = description;
		this.dateSchedule = dateSchedule;
		this.cliente = cliente;
		this.item = item;
		this.subitem = subitem;
	}
}
