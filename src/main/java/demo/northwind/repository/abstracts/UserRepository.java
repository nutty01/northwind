package demo.northwind.repository.abstracts;

import demo.northwind.model.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);

    @Modifying
    @Query("update User u set u.email = :email where u.id = :id")
    User updateEmail(@Param(value = "email") String email, @Param(value = "id") Integer id);
}
