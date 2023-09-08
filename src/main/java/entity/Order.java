package entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    @Column (name = "total_sum")
    private Integer totalSum;

    @Column (name = "orders_fk")
    private Integer ordersFk;

    @ManyToOne
    private User users;

    @OneToOne
    private Customer customers;

    @ManyToMany
    @JoinTable(name = "orders_orders_details",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_details_id"))
    private List <OrderDetails> orderDetails;

    @ManyToMany
    @JoinTable(name = "orders_customers",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id"))
    private List <Customer> customersList;
}
