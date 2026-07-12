package com.task.springboot.SupportTicketAPI.dto;

public record TicketDto(
        Long ticketId,
        String title,
        String description,
        String ticketStatus
) {
}
