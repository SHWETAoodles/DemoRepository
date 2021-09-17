package com.Emp.training.ResponseHandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Emp.training.customException.EmptyInputException;
//@controllerAdvice handles exception globally
@ControllerAdvice
public class MyControllerAdvice<HttpRequestMethodNotSupportedException, HttpHeaders, WebRequest> {
@ExceptionHandler(EmptyInputException.class)
public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
{
	return new ResponseEntity<String>("input fields are empty,please look into it",HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
{
	return new ResponseEntity<String>("no value is present in DB,please change your Request",HttpStatus.NOT_FOUND);
}

protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,HttpHeaders headers,
		HttpStatus status,WebRequest Request)
{
	return new ResponseEntity<Object>("please change your http method type request",HttpStatus.NOT_FOUND);
}


}
