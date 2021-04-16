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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pjo_clienteid")
	private Long id;
	
	@Column(name= "pjo_nome")
	private String name;
	
	@Column(name = "pjo_datagarantia")
	private Instant dateWarranty;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_empreendimentoid", nullable = false)
	private Empreendimento empreendimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_unidadeid", nullable = false)
	private Unidades unidades;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_blocoid", nullable = false)
	private Bloco blocos;
	
	public Cliente (String name, Instant dateWarranty, Empreendimento empreendimento, Unidades unidades, Bloco blocos) {
		this.name = name;
		this.dateWarranty = dateWarranty;
		this.empreendimento = empreendimento;
		this.unidades = unidades;
		this.blocos = blocos;
	}

}
