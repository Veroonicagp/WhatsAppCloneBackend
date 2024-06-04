package veronica.whatsappclone.chat.domain;

import java.util.Set;

import veronica.whatsappclone.message.domain.Message;
import veronica.whatsappclone.user.domain.User;

public class Chat {

    private long id;
    private Set<User> contacts;
    private Iterable<Message> messages;
    
}
