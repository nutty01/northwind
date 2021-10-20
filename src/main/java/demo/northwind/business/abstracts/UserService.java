package demo.northwind.business.abstracts;

import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.model.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user);
    DataResult<User> getByEmail(String email);
    Result updateEmail(String email, int userId);
}
