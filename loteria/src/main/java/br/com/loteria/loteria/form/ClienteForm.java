package br.com.loteria.loteria.form;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.loteria.loteria.modelo.Cliente;

public class ClienteForm {
	@NotNull @Email
	private String email;
	@NotNull @NotEmpty
	private String nome;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente converter() {
		return new Cliente(this.email,this.nome);
	}
}
