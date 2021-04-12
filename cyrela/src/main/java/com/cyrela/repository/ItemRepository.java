package com.cyrela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrela.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
