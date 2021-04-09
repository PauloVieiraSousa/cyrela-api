package com.cyrela.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pjo_itemid")
	private Long id;
	
	@Column(name="pjo_item")
	private String description;

	
	public Item() {}

	public Item(String description) {
		this.description = description;
	}


}
