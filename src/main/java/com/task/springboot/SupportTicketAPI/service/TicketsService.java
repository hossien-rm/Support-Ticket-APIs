package com.task.springboot.SupportTicketAPI.service;


import com.task.springboot.SupportTicketAPI.entity.TicketEntity;

import java.util.List;

public interface TicketsService {
    List<TicketEntity> findAllTickets();

    TicketEntity findByIdTickest(int ticket_id);

    TicketEntity saveTicket(TicketEntity objTicket);

    void deleteTickets(int id);
}
