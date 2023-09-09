package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String surname;
    private char phone;

    @Column(name = "customers_id")
    private Integer customersId;

    @OneToOne
    User users;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<OrderDetails> orderDetails;

    @ManyToMany
    @JoinTable(name = "order_customers",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orderList;

}
