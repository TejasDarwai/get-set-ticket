package myapp.getsetticket.controller;

import myapp.getsetticket.entity.Ticket;
import myapp.getsetticket.entity.User;
import myapp.getsetticket.service.TicketService;
import myapp.getsetticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
    }

    @GetMapping("/getTicket/{ticketId}")
    public ResponseEntity<Ticket> getRequestedTicket(@PathVariable String ticketId){
        return new ResponseEntity<>(ticketService.getTicket(ticketId), HttpStatus.OK);
    }

    @GetMapping("/getTicketByUserId/{userId}")
    public ResponseEntity<List<Ticket>> getRequestedTicketByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ticketService.getTicketsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/searchTicket")
    public ResponseEntity<List<Ticket>> searchTicket(@RequestParam(value = "source",defaultValue = "", required = false) String source,
                                                     @RequestParam(value = "destination", defaultValue = "", required = false) String destination,
                                                     @RequestParam(value = "journeyStartDate", defaultValue = "", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date journeyStartDate){
        return new ResponseEntity<>(ticketService.searchTicket(source, destination, journeyStartDate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable String ticketId){
        return new ResponseEntity<Void>(ticketService.deleteTicket(ticketId), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        return new ResponseEntity<>(ticketService.getAllTicket(), HttpStatus.OK);
    }
}
