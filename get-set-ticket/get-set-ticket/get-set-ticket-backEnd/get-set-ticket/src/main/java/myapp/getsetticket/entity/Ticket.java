package myapp.getsetticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "ticket_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {
    @Id
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date journeyStartDate;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date journeyEndDate;
    private String name;
    private Long age;
    private String gender;
    private String pnrNo;
    private String trainNo;
    private String trainName;
    private String action;
}
