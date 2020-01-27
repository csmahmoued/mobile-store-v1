package net.store.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

	public NotFoundException(String mgs){
		super(mgs);
	}
	
	
	@Override
	public HttpStatus getStatusCode() {
			return HttpStatus.NOT_FOUND;
	}

}
