package br.com.banco.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//TODO ERRO DA APICAÇÃO VAI PASSAR POR AQUI,
//FAZEMOS O TRATAMENTO DO RETORNO.
@ControllerAdvice
public class AplicationExceptionHandler  extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> allExceptions(Exception ex, WebRequest request,HttpStatus status){
		
		 ExceptionDetails exceptionDetails = ExceptionDetails.builder()
	                .timestamp(LocalDateTime.now())
	                .status(status.value())
	                .title("teste")
	                .details(ex.getMessage())	                
	                .developerMethod(ex.getClass().getName())
	                .build();
		 
		return new ResponseEntity<>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}

	
	
}
