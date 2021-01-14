package br.com.loteria.loteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loteria.loteria.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Long>{

	Cliente findByEmail(String email);
	
	
}
