package veronica.whatsappclone.message.domain;


import java.time.Instant;

import veronica.whatsappclone.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "message")
public class Message {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    private String text;

    private Instant instant;


    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false,updatable = false)
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false, updatable = false)
    private User receiver;
    public Message(String text, Instant instant,User sender, User receiver) {
        this.id = 0;
        this.text = text;
        this.instant = instant;
        this.sender = sender;
        this.receiver = receiver;
    }
    

    protected Message(){}

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }
    
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDateTime() {
        return instant;
    }

    public void setDateTime(Instant dateTime) {
        this.instant = dateTime;
    }


     


    
}
