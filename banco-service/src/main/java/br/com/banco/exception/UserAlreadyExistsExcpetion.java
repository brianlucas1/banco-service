package br.com.banco.exception;

public class UserAlreadyExistsExcpetion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsExcpetion(String msg) {
		super(msg);
	}

}
