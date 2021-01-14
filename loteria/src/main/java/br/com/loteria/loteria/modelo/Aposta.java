package br.com.loteria.loteria.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.loteria.loteria.repository.BolasRepository;



@Entity
public class Aposta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@OneToMany(mappedBy = "aposta")
	private List<Bolas> bolas = new ArrayList<>();
	@ManyToOne
	@JsonManagedReference
	private Cliente cliente;
	
	
	
	public Aposta() {
		
	}
	
	public Aposta(Cliente cliente) {
		
		

		
				
		this.cliente = cliente;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	
	

	public List<Bolas> getBolas() {
		return bolas;
	}

	public void setBolas(Bolas bola) {
		this.bolas.add(bola);
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
