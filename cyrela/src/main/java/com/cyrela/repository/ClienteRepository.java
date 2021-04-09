package com.cyrela.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cyrela.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}
