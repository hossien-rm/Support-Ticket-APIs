package com.task.springboot.SupportTicketAPI.exception;

public class TicketsNotFoundException extends RuntimeException {
    public TicketsNotFoundException(String message) {
        super(message);
    }
}
