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
@Entity(name = "subitem")
public class SubItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pjo_subitemid")
	private Long id;
	
	@Column(name="pjo_subitem")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pjo_itemid", nullable = false)
	private Item item;


	public SubItem(String description, Item item) {
		this.description = description;
		this.item = item;
	}


}
