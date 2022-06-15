package br.com.banco.exception;

public class PessoaAlreadySaveInDataBase extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PessoaAlreadySaveInDataBase(String msg) {
		super(msg);
	}

}
