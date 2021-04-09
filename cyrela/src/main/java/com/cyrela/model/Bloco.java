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
@Entity(name="blocos")
public class Bloco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pjo_blocoid")
	private Long id;
	
	@Column(name = "pjo_bloco")
	private String bloco;

	
	public Bloco(String bloco) {
		this.bloco = bloco;
	}
}
