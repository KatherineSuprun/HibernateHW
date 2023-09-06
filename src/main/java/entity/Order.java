package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "total_sum")
    private Integer totalSum;

    @ManyToOne
    User users;

    @OneToOne
    Customer customers;
}
