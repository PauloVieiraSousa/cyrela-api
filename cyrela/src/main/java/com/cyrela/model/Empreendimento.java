package com.cyrela.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "empreendimento")
public class Empreendimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pjo_empreendimentoid")
	private Long id;
	
	@Column(name = "pjo_descricao")
	private String description;
	

	public Empreendimento(String description) {
		this.description = description;
	}
	
	
}
