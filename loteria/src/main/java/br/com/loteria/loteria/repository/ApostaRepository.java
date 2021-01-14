package br.com.loteria.loteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loteria.loteria.modelo.Aposta;


public interface ApostaRepository extends JpaRepository<Aposta,Long>{
	List<Aposta> findByCliente_Email(String email);
}
