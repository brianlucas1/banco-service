package br.com.banco.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.exception.ApiException;



@RestControllerAdvice
//CONTROLE DE EXECPTION
public class AdviceController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	//MAPEADO PARA SEMPRE QUE CHAMAR A API E DER ERRO
	// RETORNAR ERRO 404
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiException handleValidationErros(MethodArgumentNotValidException ex){
		
		BindingResult bindResult = ex.getBindingResult();
		// A função do map é pegar um objeto e transformar em outro
		// vai pegar o objeto de erro e transoformar em uma lista somente do erro que foi criado no error.propriets
		List<String> messages = bindResult.getAllErrors()
		.stream()
		.map( ObjectError -> ObjectError.getDefaultMessage() )
		.collect(Collectors.toList());
		return new ApiException(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public  ResponseEntity  handleResponseException (ResponseStatusException ex){
		
		String menssagemErro = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		ApiException  apiErrors = new ApiException(menssagemErro);
		
		return new ResponseEntity(apiErrors,codigoStatus);
		
	}
	

}
