package br.edu.cesmac.agendaapi.resources;


import java.net.URI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.agendaapi.domain.Contato;
import br.edu.cesmac.agendaapi.repository.ContatoRepository;
import br.edu.cesmac.agendaapi.service.ContatosService;

@RestController
@RequestMapping("/contatos")
public class ContatosResources {
	
	@Autowired
	private ContatosService contatoService;

	@GetMapping
	public List<Contato> listartodos() {
		return contatoService.listar();
	}
	
	@PostMapping
	public  ResponseEntity<Void>  salvar(@Validated @RequestBody Contato contato) {
		contatoService.salvar(contato);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(contato.getIdContato()).toUri();
		
		 return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public void atualizar(@Validated @RequestBody Contato contato) {
		contatoService.atualizar(contato);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idContato) throws Exception {
		contatoService.deletarPorId(idContato);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> buscarPorId(@PathVariable("id") Long idContato) throws Exception {
		Contato contato = contatoService.buscarPorId(idContato);
		return ResponseEntity.ok(contato);
	}
	
}
