package br.com.banco.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.PessoaDto;
import br.com.banco.model.PessoaModel;

@RestController
@RequestMapping("/api")
public class PessoaController {

	
	@PostMapping
	public PessoaModel criaPessoa(@RequestBody @Valid PessoaDto pessoaDTO) {
		
		String teste = null;
		
		if(teste == null) {
			throw new NullPointerException();
		}
		
		PessoaModel pessoaModel = new PessoaModel();		
		BeanUtils.copyProperties(pessoaDTO,pessoaModel);	
		
		return null;
	}
	
	
	@GetMapping
	public void test() {
		
		String teste = null;
		
		if(teste == null) {
		
		}
		
	}
	
}
