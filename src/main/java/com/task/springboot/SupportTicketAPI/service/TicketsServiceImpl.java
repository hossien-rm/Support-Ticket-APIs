package com.task.springboot.SupportTicketAPI.service;


import com.task.springboot.SupportTicketAPI.constant.TicketStatus;
import com.task.springboot.SupportTicketAPI.entity.TicketEntity;
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
        return userTicketsRepository.findById(ticket_id).orElse(null);
    }


    @Override
    public TicketEntity saveTicket(TicketEntity objTicket){
        objTicket.setTicketStatus(TicketStatus.OPEN);
        return userTicketsRepository.save(objTicket);
    }

    @Override
    public void deleteTickets(int id){
        userTicketsRepository.deleteById(id);
    }

}
