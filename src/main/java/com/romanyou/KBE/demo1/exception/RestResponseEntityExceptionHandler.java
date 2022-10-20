package com.romanyou.KBE.demo1.exception;


import com.romanyou.KBE.demo1.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author Roman
 * Handles http request status and message delivery
 * Error Handling
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> emptyFieldException(ProductNotFoundException productNotFoundException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, productNotFoundException.getMessage());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }




}
