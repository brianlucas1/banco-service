package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.PessoaModel;
import br.com.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	public PessoaModel newPessoa() {
		
		return null;
	}
	
	
}
