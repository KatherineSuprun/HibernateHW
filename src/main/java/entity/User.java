package entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User {


    @Id
    @Column (name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String username;
    private String email;
    private String role;

    @Column(name = "users_fk")
    private Integer usersFk;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Order> orders;

    @OneToOne
    private Customer customers;

}
