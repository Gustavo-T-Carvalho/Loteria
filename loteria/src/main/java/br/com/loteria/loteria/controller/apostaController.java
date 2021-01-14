package br.com.loteria.loteria.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loteria.loteria.dto.ApostaDto;
import br.com.loteria.loteria.dto.ClienteDto;

import br.com.loteria.loteria.form.ClienteForm;

import br.com.loteria.loteria.modelo.Cliente;
import br.com.loteria.loteria.modelo.Aposta;
import br.com.loteria.loteria.modelo.Bolas;
import br.com.loteria.loteria.repository.ApostaRepository;
import br.com.loteria.loteria.repository.BolasRepository;
import br.com.loteria.loteria.repository.ClienteRepository;



@RestController
@RequestMapping("/apostas")
public class apostaController {
	
	@Autowired
	private ApostaRepository apostaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private BolasRepository bolasRepository;
	
	@GetMapping
	public List<ApostaDto> lista(String email){
		if(email == null) {
			List<Aposta> apostas = apostaRepository.findAll();
			return ApostaDto.converter(apostas);
		}else {
			List<Aposta> apostas = apostaRepository.findByCliente_Email(email);
			return ApostaDto.converter(apostas);
			
		}
	}
	
	@GetMapping("/consulta/{email}")
	public List<ApostaDto> detalhar(@PathVariable String email){
		
		List<Aposta> apostas = apostaRepository.findByCliente_Email(email);
		return ApostaDto.converter(apostas);
		
	}
	
	@PostMapping("/nova/{email}")
	@Transactional
	public ResponseEntity<ApostaDto> cadastrar(@PathVariable String email, UriComponentsBuilder uriBuilder){
		Cliente cliente = clienteRepository.findByEmail(email);
		 
		
		Aposta aposta = new Aposta(cliente);
		Aposta apostaRetornada = apostaRepository.save(aposta);
		
		for (int i = 0; i < 6; i++) {
			Bolas bola = new Bolas(apostaRetornada);
			
			bolasRepository.save(bola);
			apostaRetornada.setBolas(bola);
		}
		
	
		URI uri = uriBuilder.path("/apostas/consulta/{email}").buildAndExpand(cliente.getEmail()).toUri();
		return ResponseEntity.created(uri).body(new ApostaDto(apostaRetornada));
	}
	


	
	
}
