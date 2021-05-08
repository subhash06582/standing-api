package com.sapient.position.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(CustomResponseEntityExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		if (logger.isErrorEnabled()) {
			logger.error("handleAllException {}", response);
		}
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	protected ResponseEntity<Object> handleBindException(
			BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), "Missing required query param",
				ex.getBindingResult().toString());
		
		if (logger.isErrorEnabled()) {
			logger.error("handleBindException {}", response);
		}

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

}
