package br.com.banco.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDetails implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}