package com.cinesage.ticket_service.service;

import com.cinesage.ticket_service.dto.TicketDTO;
import com.cinesage.ticket_service.entity.Ticket;
import com.cinesage.ticket_service.mapper.TicketMapper;
import com.cinesage.ticket_service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

   @Autowired
   private TicketRepository ticketRepository;

   public TicketDTO getTicket(Long ticketId){
      return ticketRepository.findById(ticketId)
              .map(TicketMapper::toDTO)
              .orElseThrow(() -> new RuntimeException("Ticket not found!"));
   }

   public String bookTicket(TicketDTO ticketDTO){
      ticketRepository.save(new Ticket(
              ticketDTO.getMovieId(),
              ticketDTO.getUserId(),
              ticketDTO.getSeatNumber(),
              ticketDTO.getShowTime(),
              ticketDTO.getTheaterId()
      ));
      return "Tickets booked!";
   }

   public Page<TicketDTO> getAllTickets(Pageable pageable){
      return new PageImpl<>(
              ticketRepository.findAll()
              .stream()
                      .map(TicketMapper::toDTO)
                      .toList(), pageable, ticketRepository.count()
      );
   }

}
