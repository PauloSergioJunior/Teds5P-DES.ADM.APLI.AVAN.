package br.com.bank.acme.exceptions;

public class ClientNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1882772027566209342L;
	
	public ClientNotFoundException(String menssage, Throwable erro) {
		super(menssage,erro);
	}
	
	public ClientNotFoundException(String message) {
		super(message);
	}

}