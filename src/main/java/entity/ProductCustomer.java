package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

@Entity
@Getter
@Setter
@Table(name = "products_customers")
public class ProductCustomer {

    @Id
    private Integer id;

    @Column(name = "products_id")
    private Integer productsId;

    @Column(name = "customers_id")
    private Integer customersId;
}
