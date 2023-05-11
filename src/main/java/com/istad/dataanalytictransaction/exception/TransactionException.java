package com.istad.dataanalytictransaction.exception;


import com.istad.dataanalytictransaction.utils.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class TransactionException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors().stream().map
                        (DefaultMessageSourceResolvable::getDefaultMessage).toList();
//        ResponseEntity need to have body field and status
        return new ResponseEntity<>(
                Response.<Object>badRequest().setMessage(errors).setSuccess(false), HttpStatus.BAD_REQUEST
        );
    }
}

