package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customers_id")
    private String customersId;

    @Column(name = "customers_fk")
    private String customersFk;

    @OneToMany
    Order orders;

    @OneToMany
    OrderDetails orderDetails;
}
