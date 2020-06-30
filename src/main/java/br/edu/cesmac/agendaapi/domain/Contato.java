package br.edu.cesmac.agendaapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContato;
	
	@NotEmpty(message = "Obrigatório o informar o nome do contato!")
	private String nome;
	
	@NotEmpty(message = "Obrigatório o informar o número do contato!")
	private String num_contato;
	
	@Email(message = "Favor informar um e-mail válido")
	private String email;
	
	
	public Long getIdContato() {
		return idContato;
	}
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNum_contato() {
		return num_contato;
	}
	public void setNum_contato(String num_contato) {
		this.num_contato = num_contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
