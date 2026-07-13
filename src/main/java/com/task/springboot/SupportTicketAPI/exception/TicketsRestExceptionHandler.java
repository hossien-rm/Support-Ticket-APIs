package com.task.springboot.SupportTicketAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketsRestExceptionHandler {

    //handle just Not found Exception.
    @ExceptionHandler
    public ResponseEntity<TicketsErrorResponse> handleException(TicketsNotFoundException exc){

        TicketsErrorResponse error=new TicketsErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // handle all Exception.
    @ExceptionHandler
    public ResponseEntity<TicketsErrorResponse> handleAllException(Exception ex){

        TicketsErrorResponse error=new TicketsErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
