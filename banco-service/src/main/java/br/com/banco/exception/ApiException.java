package br.com.banco.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

//ESSA CLASSE TRATA OS ERROS DO BEAN VALIDATION DO SPRING BOOT
public class ApiException {

	@Getter
	private List<String> erros;
	
	public ApiException(List<String> erros){
		this.erros = erros;
	}
	
	public ApiException(String erros){
		this.erros = Arrays.asList(erros);
	}
	
}
