package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "orders_customers")
public class OrderCustomer {

    @Id
    private Integer id;

    @Column(name = "orders_id")
    private Integer productsId;

    @Column(name = "customers_id")
    private Integer customersId;

    @ManyToMany
    @JoinTable(name = "orders_orders_details",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_details_id"))
    private List<OrderDetails> orderDetails;

    @ManyToMany
    @JoinTable(name = "orders_customers",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id"))
    private List <Customer> customersList;
}
