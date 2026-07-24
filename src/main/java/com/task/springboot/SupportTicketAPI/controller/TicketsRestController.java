package com.task.springboot.SupportTicketAPI.controller;


import com.task.springboot.SupportTicketAPI.dto.TicketDto;
import com.task.springboot.SupportTicketAPI.exception.TicketsNotFoundException;
import com.task.springboot.SupportTicketAPI.mapper.TicketMapper;
import com.task.springboot.SupportTicketAPI.service.TicketsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TicketsRestController {
    private final TicketsService ticketsService;

    @GetMapping("/tickets")
    public List<TicketDto> findAllTickets(){
        return TicketMapper.entityToDto(ticketsService.findAllTickets());
    }

    @GetMapping("/tickets/{ticket_id}")
    public TicketDto findByTickets(@PathVariable Integer ticket_id){

        if( ticket_id<0 ){
            throw new TicketsNotFoundException("Your ticket id which post is not valid!!");
        }

        return TicketMapper.entityToDto(ticketsService.findByIdTickest(ticket_id));
    }

    @PostMapping("/tickets")
    public TicketDto saveTickets(@RequestBody @Valid TicketDto ticketDto){
        return TicketMapper.entityToDto(ticketsService.saveTicket(TicketMapper.dtoToEntity(ticketDto)));
    }

    @PutMapping("/tickets")
    public TicketDto updateTicket(@RequestBody @Valid TicketDto ticketDto){
        return TicketMapper.entityToDto(ticketsService.saveTicket(TicketMapper.dtoToEntity(ticketDto)));
    }


    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Integer id){
        if( id<0){
            throw new TicketsNotFoundException("Your ticket id which delete is not valid!");
        }
       ticketsService.deleteTickets(id);
    }

}
