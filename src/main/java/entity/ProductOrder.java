package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products_orders")
public class ProductOrder {

    @Id
    private Integer id;

    @Column(name = "orders_id")
    private int ordersId;

    @Column(name = "products_id")
    private String productsId;
}
