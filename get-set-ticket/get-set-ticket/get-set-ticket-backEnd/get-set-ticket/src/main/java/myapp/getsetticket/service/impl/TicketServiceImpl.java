package myapp.getsetticket.service.impl;

import myapp.getsetticket.entity.Ticket;
import myapp.getsetticket.entity.User;
import myapp.getsetticket.exceptions.UserNotFoundException;
import myapp.getsetticket.repository.TicketRepository;
import myapp.getsetticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public Ticket saveTicket(Ticket ticket) {
        String randomticketId = UUID.randomUUID().toString();
        ticket.setTicketId(randomticketId);
        System.out.println(ticket.getJourneyStartDate());
        System.out.println(ticket.getJourneyEndDate());
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(String ticketId) {
        Ticket ticket = this.ticketRepository.findById(ticketId).orElseThrow(()->new UserNotFoundException("Requested Ticket "+ticketId+" Not Found"));
        return ticket;
    }

    @Override
    public List<Ticket> getAllTicket() {
        return this.ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByUserId(String userId) {
        return this.ticketRepository.getTicketsByUserId(userId);
    }

    @Override
    public List<Ticket> searchTicket(String source, String destination, Date journeyStartDate) {
        Ticket ticket = new Ticket();
        ticket.setSource(source);
        ticket.setDestination(destination);
        //ticket.setJourneyStartDate(journeyStartDate);
        Example<Ticket> example = Example.of(ticket);
        System.out.println(ticket);
        List<Ticket>tickets=this.ticketRepository.findAll(example);
        return tickets;
    }

    @Override
    public Void deleteTicket(String ticketId) {
        this.ticketRepository.deleteById(ticketId);
        return null;
    }
}
