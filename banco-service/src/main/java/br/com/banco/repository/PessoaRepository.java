package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Integer>{
	
	@Query(value = " from PessoaModel  where cpf_or_cnpj = :cpf_cnpj")
	PessoaModel consultaCpf(@Param("cpf_cnpj") String cpf_cnpj);

}
