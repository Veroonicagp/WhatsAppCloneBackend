package veronica.whatsappclone.user.adapter;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import veronica.whatsappclone.user.domain.User;
import veronica.whatsappclone.user.service.UserService;

@RestController
public class UserController { 

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getMethodName(@PathVariable(name = "id") long id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User newUser) {
        return this.userService.creatUser(newUser); 
    }

   // @PostConstruct
    public void initialize() throws IOException {
    	User user1 = new User ("333333333");
        user1.setId(4);
        userService.creatUser(user1);
        User user2 = new User ("111111111");
        user2.setId(5);
        userService.creatUser(user2);
        User user3 = new User ("200200200");
        user3.setId(6);
        userService.creatUser(user3);
    }
}