package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

@Entity
@Getter
@Setter
@Table(name = "products")

public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    Customer customers;

    @ManyToMany
    Order orders;
}
