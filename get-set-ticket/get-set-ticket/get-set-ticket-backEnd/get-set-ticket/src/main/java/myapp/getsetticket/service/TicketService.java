package myapp.getsetticket.service;

import myapp.getsetticket.entity.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);

    Ticket getTicket(String ticketId);

    List<Ticket> getAllTicket();

    List<Ticket> getTicketsByUserId(String userId);

    List<Ticket> searchTicket(String source, String destination, Date journeyStartDate);

    Void deleteTicket(String ticketId);
}
