package br.com.banco.exception;

public class EmailAlreadyExistsExcpetion extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsExcpetion(String msg) {
		super(msg);
	}
	
}
