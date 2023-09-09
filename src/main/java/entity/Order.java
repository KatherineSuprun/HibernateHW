package entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinTable(name = "orders_product",
    joinColumns = @JoinColumn(name = "orders_id"),
    inverseJoinColumns = @JoinColumn (name = "products_id"))
    private List<Product> productsList;

    @ManyToMany(mappedBy = "shopProducts")
    private List<Customer> customerList;

    @ManyToMany
    @JoinTable(name = "orders_orders_details",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn (name = "orders_details_id"))
    private List<OrderDetails> orderDetailsList;



}
