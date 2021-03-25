package br.com.bank.acme.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {        

	//....

	    @ExceptionHandler(ClientNotFoundException.class)
	    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ClientNotFoundException cnfe,
	            HttpServletRequest request) {

	        ErrorDetail errorDetail = new ErrorDetail();
	        errorDetail.setTimeStamp(new Date().getTime());
	        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
	        errorDetail.setTitle("Recurso não encontrado.");
	        errorDetail.setDetail(cnfe.getMessage());
	        errorDetail.setDeveloperMessage(cnfe.getClass().getName());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
	    }
}	    