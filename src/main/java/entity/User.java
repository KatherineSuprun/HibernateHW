package entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column (name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "users_num")
    private int usersNum;

    @Column(name = "users_fk")
    private int usersFk;

    @OneToMany
    private Orders orders;

    @OneToOne
    private Customer customers;

}
