package demo.northwind.business.concretes;

import demo.northwind.business.abstracts.UserService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.core.utilities.results.SuccessDataResult;
import demo.northwind.core.utilities.results.SuccessResult;
import demo.northwind.repository.abstracts.UserRepository;
import demo.northwind.model.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(), "Data listed");
    }

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User added successfully");
    }


    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.getByEmail(email), "User founded");
    }

    @Override
    public DataResult<User> updateEmail(String email, int id) {
        User user = userRepository.getById(id);
        user.setEmail(email);
        return new DataResult<User>(userRepository.save(user), true,"updated");
    }


}
