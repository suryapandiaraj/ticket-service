package com.cinesage.ticket_service.mapper;

import com.cinesage.ticket_service.dto.TicketDTO;
import com.cinesage.ticket_service.entity.Ticket;

public class TicketMapper {

   public static TicketDTO toDTO(Ticket ticket){
      return new TicketDTO(
              ticket.getMovieId(),
              ticket.getSeatNumber(),
              ticket.getShowTime(),
              ticket.getUserId(),
              ticket.getTheaterId()
      );
   }
}
