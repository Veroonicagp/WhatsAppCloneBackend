package veronica.whatsappclone.chat.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import veronica.whatsappclone.message.domain.Message;
import veronica.whatsappclone.message.service.MessageService;
import veronica.whatsappclone.user.service.UserService;

@RestController
public class ChatController {


    MessageService messageService;
    UserService userService;

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }
    
    @GetMapping("/chat")
    public Iterable<Message> getChats(@RequestParam(name = "user1") long user1,
                                      @RequestParam(name = "user2") long user2)  {

        Iterable<Message> messages1 = messageService.getAllByUsers(user1, user2);
        return messages1;

    
    }
}
