package entity;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@Entity(name = "products")

public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nname")
    private String nname;
    private Integer quantity;

    @ManyToMany(mappedBy = "productsList")
    private List<Order> ordersList;
}
