package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "orders_orders_details")

public class OrderOrderDetails {

    @Id
    private Integer id;

    @Column(name = "orders_details_id")
    private Integer orderDetailsId;

    @Column(name = "orders_id")
    private Integer ordersId;

}
