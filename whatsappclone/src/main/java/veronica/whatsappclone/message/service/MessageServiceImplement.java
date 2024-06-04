package veronica.whatsappclone.message.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import veronica.whatsappclone.message.domain.Message;
import veronica.whatsappclone.message.domain.MessageRepo;

@Service
public class MessageServiceImplement implements MessageService{

    private MessageRepo messageRepository;

    public MessageServiceImplement(MessageRepo messageRepo){
        this.messageRepository = messageRepo;
    }


    @Override
    public Message getMssg(long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    ///atraves de un id se obtienen mensajes tanto enviados como recibidos,
    // creamos una nueva lista donde añadimos tanto unos como otros
    // y devolvemos la lista en conjunto
    @Override
    public Iterable<Message> getAllByUserId(long id) {
        Iterable<Message> send = messageRepository.findBySenderId(id);
        Iterable<Message> recived = messageRepository.findByReceiverId(id);
        List<Message> total = new ArrayList<>();
        send.forEach(total::add);
        recived.forEach(total::add);
        return total;

    }

    @Override
    public void create(Message entity) {
        this.messageRepository.save(entity);
    }

    
    @Override
    public Iterable<Message> getAllByUsers(long user1Id, long user2Id) {
        Iterable<Message> mssg12 = messageRepository.findBySenderIdAndReceiverId(user1Id, user2Id);
        Iterable<Message> mssg21 = messageRepository.findBySenderIdAndReceiverId(user2Id, user1Id);
        List <Message> chat = new ArrayList<>();
        mssg12.forEach(chat::add);
        mssg21.forEach(chat::add);
        chat.sort(null);
        return chat;
    }

    @Override
    public void delete() {
        this.messageRepository.deleteAll();
    }





    
}
