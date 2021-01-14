package br.com.loteria.loteria.dto;

import br.com.loteria.loteria.modelo.Cliente;

public class ClienteDto {
	private long id;
	private String email;
	private String nome;
	
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
	}
	
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	
}
