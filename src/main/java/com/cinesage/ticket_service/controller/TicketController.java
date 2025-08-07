package com.cinesage.ticket_service.controller;

import com.cinesage.ticket_service.dto.TicketDTO;
import com.cinesage.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

   @Autowired
   private TicketService ticketService;

   @GetMapping("/getTicket/{ticketId}")
   public ResponseEntity<TicketDTO> getTicket(@PathVariable Long ticketId){
      return ResponseEntity.ok(ticketService.getTicket(ticketId));
   }

   @PostMapping("/bookTicket")
   public ResponseEntity<String> bookTicket(@RequestBody TicketDTO ticketDTO){
      return ResponseEntity.ok(ticketService.bookTicket(ticketDTO));
   }

   @GetMapping("/getAllTickets")
   public ResponseEntity<Page<TicketDTO>> getAllTickets(Pageable pageable){
      return ResponseEntity.ok(ticketService.getAllTickets(pageable));
   }

}
