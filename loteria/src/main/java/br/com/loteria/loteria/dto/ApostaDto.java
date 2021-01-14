package br.com.loteria.loteria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.loteria.loteria.modelo.Aposta;
import br.com.loteria.loteria.modelo.Bolas;


public class ApostaDto {
	private Long id;
	private String email;
	private List<Bolas> aposta;
	
	
	public ApostaDto(Aposta aposta) {
		this.id = aposta.getId();
		this.email = aposta.getCliente().getEmail();
		this.aposta = aposta.getBolas();
		
	}
	
	


	public Long getId() {
		return id;
	}
	public List<Bolas> getAposta() {
		return aposta;
	}
	public String getEmail() {
		return email;
	}


	public static List<ApostaDto> converter(List<Aposta> apostas) {
		return apostas.stream().map(ApostaDto::new).collect(Collectors.toList());
		
	}
	
	
}
