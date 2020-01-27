package net.store.errors;

import org.springframework.http.HttpStatus;

public abstract  class BaseException extends  RuntimeException {

	public BaseException() {
		
	}
    public BaseException(String message){
        super(message);
    }
    abstract  public HttpStatus getStatusCode();

}
