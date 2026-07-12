package com.task.springboot.SupportTicketAPI.repository;

import com.task.springboot.SupportTicketAPI.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTicketsRepository extends JpaRepository<TicketEntity,Integer> {

}
