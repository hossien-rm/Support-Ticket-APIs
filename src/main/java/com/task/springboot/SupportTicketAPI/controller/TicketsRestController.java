package com.task.springboot.SupportTicketAPI.controller;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.springboot.SupportTicketAPI.dto.TicketDto;
import com.task.springboot.SupportTicketAPI.entity.TicketEntity;
import com.task.springboot.SupportTicketAPI.exception.TicketsNotFoundException;
import com.task.springboot.SupportTicketAPI.mapper.TicketMapper;
import com.task.springboot.SupportTicketAPI.service.TicketsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketsRestController {
    private final TicketsService ticketsService;
    private final ObjectMapper objectMapper;

    public TicketsRestController(TicketsService ticketsService, ObjectMapper objectMapper) {
        this.ticketsService = ticketsService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/tickets")
    public List<TicketDto> findAllTickets(){
        return TicketMapper.entityToDto(ticketsService.findAllTickets());
    }

    @GetMapping("/tickets/{ticket_id}")
    public TicketDto findByTickets(@PathVariable Integer ticket_id){

        if(ticket_id>ticketsService.findAllTickets().size() || ticket_id<0){
            throw new TicketsNotFoundException("Your ticket id which post is not valid!!");
        }

        return TicketMapper.entityToDto(ticketsService.findByIdTickest(ticket_id));
    }

    @PostMapping("/tickets")
    public TicketDto saveTickets(@RequestBody TicketDto ticketDto){
        return TicketMapper.entityToDto(ticketsService.saveTicket(TicketMapper.dtoToEntity(ticketDto)));
    }

    @PutMapping("/tickets")
    public TicketDto updateTicket(@RequestBody TicketDto ticketDto){
        return TicketMapper.entityToDto(ticketsService.saveTicket(TicketMapper.dtoToEntity(ticketDto)));
    }

    @PatchMapping("/tickets/{patchId}")
    public TicketDto patchTicket(@PathVariable Integer patchId, @RequestBody Map<String,Object> patchLoad) throws JsonMappingException {
         TicketEntity ticketId=ticketsService.findByIdTickest(patchId);

         if(ticketId==null){
             throw new RuntimeException();
         }

         TicketEntity partialUpdate=objectMapper.updateValue(ticketId,patchLoad);

         return  TicketMapper.entityToDto(ticketsService.saveTicket(ticketId));
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Integer id){
        if(id> ticketsService.findAllTickets().size() || id<0){
            throw new TicketsNotFoundException("Your ticket id which delete is not valid!");
        }
       ticketsService.deleteTickets(id);
    }

}
