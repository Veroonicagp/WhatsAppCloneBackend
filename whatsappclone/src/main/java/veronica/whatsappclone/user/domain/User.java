package veronica.whatsappclone.user.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import veronica.whatsappclone.message.domain.Message;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true,updatable = false,nullable = false)
    private String phone;

    /// ¿?
    @OneToMany(mappedBy = "sender",targetEntity = veronica.whatsappclone.message.domain.Message.class)
    private List<Message> senderMessages;
    @OneToMany(mappedBy = "receiver",targetEntity = veronica.whatsappclone.message.domain.Message.class)
    private List<Message> recieverMessage;

    protected User() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String phone) {
        this.id = 0;
        this.phone = phone;
    }

}
