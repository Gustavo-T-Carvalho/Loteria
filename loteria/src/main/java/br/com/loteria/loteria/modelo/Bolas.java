package br.com.loteria.loteria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.loteria.loteria.repository.BolasRepository;


@Entity
public class Bolas {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JsonBackReference
	private Aposta aposta;
	int bola;
	public Bolas() {
		
	}
	public Bolas(Aposta aposta) {
		int max = 100;
		this.aposta = aposta;
		this.bola = (int)(Math.random()*max);
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aposta getAposta() {
		return aposta;
	}
	public void setAposta(Aposta aposta) {
		this.aposta = aposta;
	}
	public int getBola() {
		return bola;
	}
	public void setBola(int bola) {
		this.bola = bola;
	}
	
}
