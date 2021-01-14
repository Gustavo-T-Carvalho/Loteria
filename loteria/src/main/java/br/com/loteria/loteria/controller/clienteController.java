package br.com.loteria.loteria.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loteria.loteria.dto.ClienteDto;
import br.com.loteria.loteria.dto.ApostaDto;
import br.com.loteria.loteria.form.ClienteForm;
import br.com.loteria.loteria.modelo.Cliente;
import br.com.loteria.loteria.modelo.Aposta;
import br.com.loteria.loteria.repository.ClienteRepository;



@RestController
@RequestMapping("/clientes")
public class clienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
		Cliente cliente = form.converter();
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

}


	
	

	
	
	


	
	
