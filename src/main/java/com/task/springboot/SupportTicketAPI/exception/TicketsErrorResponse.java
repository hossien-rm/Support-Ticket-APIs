package com.task.springboot.SupportTicketAPI.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TicketsErrorResponse {
    private int status ;
    private String message;
    private Long timeStamp;

}
