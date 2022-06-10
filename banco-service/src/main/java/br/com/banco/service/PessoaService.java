package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.exception.PessoaAlreadySaveInDataBase;
import br.com.banco.model.PessoaModel;
import br.com.banco.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	public PessoaModel newPessoa(PessoaModel pess) throws PessoaAlreadySaveInDataBase {
		
		PessoaModel pess1 = repo.consultaCpf(pess.getCpf_cnpj());
			if(pess1 != null) {
				throw new ResponseStatusException(HttpStatus.OK,"ESSE USUARIO JÁ ESTÁ CADASTRADO NA BASE");
			}else {
				return repo.save(pess);
			}
	}

	public PessoaModel findById(Integer id) {
		
		return repo.findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum usuario com esse ID Cadastrado"));
	}
}
