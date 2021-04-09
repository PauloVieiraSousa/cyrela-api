package com.cyrela.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "subitem")
public class SubItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pjo_subitemid")
	private Long id;
	
	@Column(name="pjo_subitem")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pjo_itemid", nullable = false)
	private Item item;

	public SubItem() {}

	public SubItem(String description, Item item) {
		this.description = description;
		this.item = item;
	}


}
