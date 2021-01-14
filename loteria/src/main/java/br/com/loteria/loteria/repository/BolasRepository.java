package br.com.loteria.loteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loteria.loteria.modelo.Aposta;
import br.com.loteria.loteria.modelo.Bolas;

public interface BolasRepository extends JpaRepository<Bolas,Long>{

}
