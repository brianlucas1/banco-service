package br.com.banco.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

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
	                .build();
		 
		return new ResponseEntity<>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
		
	
	@ExceptionHandler(EmailAlreadyExistsExcpetion.class)
	public ResponseEntity<ExceptionDetails> emailException(EmailAlreadyExistsExcpetion ex, HttpServletRequest request){
		
		 ExceptionDetails exceptionDetails = ExceptionDetails.builder()
	                .timestamp(LocalDateTime.now())
	                .status(500)
	                .error("E-MAIL JÁ CADASTRADO NA BASE")
	                .message(ex.getMessage())
	                .path(request.getRequestURI())
	                .build();
		 
		return new ResponseEntity<>(exceptionDetails,HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler(UserAlreadyExistsExcpetion.class)
	public ResponseEntity<ExceptionDetails> emailException(UserAlreadyExistsExcpetion ex, HttpServletRequest request){
		
		 ExceptionDetails exceptionDetails = ExceptionDetails.builder()
	                .timestamp(LocalDateTime.now())
	                .status(500)
	                .error("USERNAME JÁ CADASTRADO NA BASE")
	                .message(ex.getMessage())
	                .path(request.getRequestURI())
	                .build();
		 
		return new ResponseEntity<>(exceptionDetails,HttpStatus.BAD_REQUEST);
				
	}
	
	
	
	
}
