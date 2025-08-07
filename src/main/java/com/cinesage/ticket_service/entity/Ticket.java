package com.cinesage.ticket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long ticketId;

   @Column(nullable = false)
   private Long userId;

   @Column(nullable = false)
   private Long movieId;

   @Column(nullable = false)
   private Long theaterId;

   @Column(nullable = false)
   private String seatNumber;

   @Column(nullable = false)
   private String showTime;

   public Ticket(Long movieId, Long userId, String seatNumber, String showTime, Long theaterId) {
      this.userId = userId;
      this.movieId = movieId;
      this.theaterId = theaterId;
      this.seatNumber = seatNumber;
      this.showTime = showTime;
   }

}
