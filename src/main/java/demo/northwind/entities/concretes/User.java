package demo.northwind.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
