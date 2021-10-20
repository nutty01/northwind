package demo.northwind.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    @NotBlank
    @NotNull
    private String email;

    @Column(name = "password")
    @NotBlank
    @NotNull
    private String password;


}
