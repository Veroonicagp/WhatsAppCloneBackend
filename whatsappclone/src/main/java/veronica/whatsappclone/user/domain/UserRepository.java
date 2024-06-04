package veronica.whatsappclone.user.domain;


import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    public boolean existsByPhone(String phone);
}
