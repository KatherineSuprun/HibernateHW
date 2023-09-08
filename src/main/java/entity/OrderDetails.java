package entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders_details")
public class OrderDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "time_placed")
    private LocalDateTime timePlaced;

    @Column (name = "time_updated")
    private LocalDateTime timeUpdated;

    @ManyToMany(mappedBy = "orders_orders_details")
    private List<Order> orders;
}

