package myapp.getsetticket.repository;

import myapp.getsetticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> getTicketsByUserId(String userId);

    Optional<Ticket> findById(String ticketId);
}
