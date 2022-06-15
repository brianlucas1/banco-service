package br.com.banco.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.PessoaDTO;
import br.com.banco.exception.PessoaAlreadySaveInDataBase;
import br.com.banco.model.PessoaModel;
import br.com.banco.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaService pessService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaModel criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaAlreadySaveInDataBase {
		
		PessoaModel pessoaModel = new PessoaModel();		
		BeanUtils.copyProperties(pessoaDTO,pessoaModel);		
		return pessService.newPessoa(pessoaModel);		
		 
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public PessoaModel buscaPessoaPorId(@PathVariable("id") Integer id) {

		return pessService.findById(id);
		
	}
	
}
