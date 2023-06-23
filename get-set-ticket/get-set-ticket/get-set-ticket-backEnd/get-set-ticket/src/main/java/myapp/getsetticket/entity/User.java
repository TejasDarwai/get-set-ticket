package myapp.getsetticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "user_table")
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String password;
    @ElementCollection
    private List<String> ticketToSell;
    @ElementCollection
    private List<String> ticketToBuy;
}
