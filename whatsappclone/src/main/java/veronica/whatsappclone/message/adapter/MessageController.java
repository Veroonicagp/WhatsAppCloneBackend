package veronica.whatsappclone.message.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import veronica.whatsappclone.message.domain.Message;
import veronica.whatsappclone.message.service.MessageService;

@RestController(value = "/message")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public Message getMssg(@PathParam(value = "id") long id) {
        return messageService.getMssg(id);
    }

    @GetMapping
    public Iterable<Message> getAll(@RequestParam(name="user") long userId) {
        return this.messageService.getAllByUserId(userId);
    }
    
    @GetMapping("/conversation/{userId1}/{userId2}")
    public Iterable<Message> getConversation(@PathParam(value = "userId1") long userId1 , @PathParam(value = "userId2") long userId2 ) {
        return this.messageService.getAllByUsers(userId1, userId2);
    }


}