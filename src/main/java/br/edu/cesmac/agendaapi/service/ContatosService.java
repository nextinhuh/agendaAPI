package br.edu.cesmac.agendaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.agendaapi.domain.Contato;
import br.edu.cesmac.agendaapi.repository.ContatoRepository;

@Service
public class ContatosService {

	@Autowired
	private ContatoRepository contatoRepository;

	public Contato salvar(Contato contato) {
		Contato contatoCriado = contatoRepository.save(contato);
		return contatoCriado;
	}

	public Contato atualizar(Contato contato) {
		Contato contatoAtualizada = contatoRepository.save(contato);
		return contatoAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Contato editoriaExclusao = contatoRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		contatoRepository.deleteById(id);
	}

	public Contato buscarPorId(Long id) throws Exception {
		return contatoRepository.findById(id)
				 .orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Contato> listar() {
		return contatoRepository.findAll();

	}

}
