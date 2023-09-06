package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "orders_orders_details")

public class OrderOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "orders_orders_id")
    private int orderDetailsId;

    @Column(name = "orders_id")
    private int ordersId;
}
