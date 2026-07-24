package com.task.springboot.SupportTicketAPI.dto;

import jakarta.validation.constraints.NotBlank;


public record TicketDto(

        Long ticketId,

        @NotBlank(message = "title shouldn't null or empty!" )
        String title,

        @NotBlank(message= "description should not be null or empty")
        String description,

        @NotBlank(message = "ticket status shouldn't null or empty!")
        String ticketStatus
) {
}
