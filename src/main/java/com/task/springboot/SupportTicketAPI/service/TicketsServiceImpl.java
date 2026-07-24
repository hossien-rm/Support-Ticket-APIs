package com.task.springboot.SupportTicketAPI.service;


import com.task.springboot.SupportTicketAPI.constant.TicketStatus;
import com.task.springboot.SupportTicketAPI.entity.TicketEntity;
import com.task.springboot.SupportTicketAPI.exception.TicketsNotFoundException;
import com.task.springboot.SupportTicketAPI.repository.UserTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    private final UserTicketsRepository userTicketsRepository;

    @Autowired
    public TicketsServiceImpl(UserTicketsRepository userTicketsRepository) {
        this.userTicketsRepository = userTicketsRepository;
    }

    @Override
    public List<TicketEntity> findAllTickets(){
        return userTicketsRepository.findAll();
    }

    @Override
    public TicketEntity findByIdTickest(int ticket_id){
        return userTicketsRepository.findById(ticket_id)
                .orElseThrow(()->new TicketsNotFoundException("You can not get this ticket!"));
    }


    @Override
    public TicketEntity saveTicket(TicketEntity objTicket){
        //default ticketStatus OPEN
        objTicket.setTicketStatus(TicketStatus.OPEN);
        return userTicketsRepository.save(objTicket);
    }


    @Override
    public void deleteTickets(int id){
        userTicketsRepository.findById(id)
                .orElseThrow(()->new TicketsNotFoundException("You can not delete this ticket!"));
        userTicketsRepository.deleteById(id);
    }

}
