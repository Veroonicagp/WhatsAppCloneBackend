package veronica.whatsappclone.user.service;

import java.util.Optional;

import veronica.whatsappclone.user.domain.User;


public interface UserService {

    public Iterable<User> getAllUsers();
    public User creatUser(User user);
    public Optional<User> getUser(Long id);
    public void deleteUser(Long id);

}
