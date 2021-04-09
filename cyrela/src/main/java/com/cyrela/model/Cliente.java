package com.cyrela.model;

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
@Entity(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pjo_clienteid")
	private Long id;
	
	@Column(name= "pjo_nome")
	private String name;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pjo_empreendimentoid", nullable = false)
	private Empreendimento empreendimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pjo_unidadeid", nullable = false)
	private Unidades unidades;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pjo_blocoid", nullable = false)
	private Bloco blocos;
	


	
	public Cliente(String name, Empreendimento empreendimento, Unidades unidade, Bloco bloco) {
		this.name = name;
		this.empreendimento = empreendimento;
		this.unidades = unidade;
		this.blocos = bloco;
	}
	
	

}
