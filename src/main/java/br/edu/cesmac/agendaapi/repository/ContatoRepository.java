package br.edu.cesmac.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cesmac.agendaapi.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
