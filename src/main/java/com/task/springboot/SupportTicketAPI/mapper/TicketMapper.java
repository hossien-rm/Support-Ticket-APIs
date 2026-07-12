package com.task.springboot.SupportTicketAPI.mapper;

import com.task.springboot.SupportTicketAPI.constant.TicketStatus;
import com.task.springboot.SupportTicketAPI.dto.TicketDto;
import com.task.springboot.SupportTicketAPI.entity.TicketEntity;

import java.util.ArrayList;
import java.util.List;

public class TicketMapper {

    public static TicketDto entityToDto(TicketEntity ticketEntity) {
        return new TicketDto(
                ticketEntity.getTicketId(),
                ticketEntity.getTitle(),
                ticketEntity.getDescription(),
                ticketEntity.getTicketStatus().name()
        );
    }

    public static List<TicketDto> entityToDto(List<TicketEntity> ticketEntities) {
        List<TicketDto> ticketDtos = new ArrayList<>();
        for(var ticketEntity : ticketEntities){
            ticketDtos.add(entityToDto(ticketEntity));
        }
        return ticketDtos;
    }

    public static TicketEntity dtoToEntity(TicketDto ticketDto) {
        return new TicketEntity(
                ticketDto.ticketId(),
                ticketDto.title(),
                ticketDto.description(),
                TicketStatus.valueOf(ticketDto.ticketStatus())
        );
    }

    public static List<TicketEntity> dtoToEntity(List<TicketDto> ticketDtos) {
        List<TicketEntity> ticketEntities = new ArrayList<>();
        for (var ticketDto : ticketDtos) {
            ticketEntities.add(dtoToEntity(ticketDto));
        }
        return ticketEntities;
    }
}
