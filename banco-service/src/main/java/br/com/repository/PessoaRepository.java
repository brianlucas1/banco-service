package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer>{

}
