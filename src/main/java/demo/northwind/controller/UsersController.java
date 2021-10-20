package demo.northwind.controller;

import demo.northwind.business.abstracts.UserService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.ErrorDataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.model.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {

    @Autowired
    private UserService userService;


    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)  //for all val. exc.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors=new HashMap<String,String>() ;
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
        validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"Validation Error");
        return errors;
    }

    @PutMapping(value = "/update/email")
    public Result updateEmail(@Valid @RequestParam @NotBlank @Pattern(regexp ="^\\w+(\\.\\w+)*@\\p{javaLowerCase}{2,12}+(\\.\\p{javaLowerCase}{2,6})+$") String email, @RequestParam int id) {
        return this.userService.updateEmail(email,id);
    }


}
