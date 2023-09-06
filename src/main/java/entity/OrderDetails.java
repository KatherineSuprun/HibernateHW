package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

@Entity
@Getter
@Setter
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "time_placed")
    private Integer timePlaced;

    @Column (name = "time_updated")
    private Integer timeUpdated;

    @ManyToMany
    private Order orders;