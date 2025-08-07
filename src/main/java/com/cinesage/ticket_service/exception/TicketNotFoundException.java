package com.cinesage.ticket_service.exception;


public class TicketNotFoundException extends RuntimeException {
   public TicketNotFoundException(String message) {
      super(message);
   }

   public TicketNotFoundException (String message, Throwable clause){
      super(message, clause);
   }

}
