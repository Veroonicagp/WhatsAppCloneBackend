package veronica.whatsappclone.message.service;

import veronica.whatsappclone.message.domain.Message;

public interface MessageService {

    //crea uno
    void create(Message entity);
    //obten uno
    public Message getMssg(long id);
    // muestra lista de mensages de 1 usu
    public Iterable<Message> getAllByUserId(long userId);
    // muestra lista de mensages entre 2 usu
    public Iterable<Message> getAllByUsers(long user1Id,long user2Id);
    //elimina todo
    public void delete();
    

    
}
