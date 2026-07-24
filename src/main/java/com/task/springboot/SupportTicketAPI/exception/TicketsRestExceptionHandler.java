package com.task.springboot.SupportTicketAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TicketsRestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Map<String,String> handleValidArgument(MethodArgumentNotValidException validException){

        Map<String,String> errorMap=new HashMap<>();
        validException.getBindingResult().getFieldErrors()
                .forEach(error-> errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }



    //handle just Not found Exception.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public TicketsErrorResponse handleException(TicketsNotFoundException exc){

        TicketsErrorResponse error=new TicketsErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return error;
    }

    // handle all Exception.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public TicketsErrorResponse handleAllException(Exception ex){

        TicketsErrorResponse error=new TicketsErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return error;
    }
}
