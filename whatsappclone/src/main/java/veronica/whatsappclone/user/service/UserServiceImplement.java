package veronica.whatsappclone.user.service;

import java.util.Optional;


import org.springframework.stereotype.Service;

import veronica.whatsappclone.core.UserAlreadyExistsException;
import veronica.whatsappclone.user.domain.User;
import veronica.whatsappclone.user.domain.UserRepository;

@Service
public class UserServiceImplement implements UserService{

    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
 
    }

    @Override
    public User creatUser(User user) {
        if(userRepository.existsByPhone(user.getPhone())){
            throw new UserAlreadyExistsException();
        }
        return this.userRepository.save(user);
    }


    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }





    
}
