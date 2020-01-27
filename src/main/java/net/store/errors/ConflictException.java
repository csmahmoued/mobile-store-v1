package net.store.errors;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {

	ConflictException(String msg){
		super(msg);
	}
	
	
	
	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.CONFLICT;
	}

	
	
}
