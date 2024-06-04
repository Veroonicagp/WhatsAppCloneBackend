package veronica.whatsappclone.message.domain;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message,Long>{

    public Iterable<Message> findBySenderId(long id);
    public Iterable<Message> findByReceiverId(long id);
    public Iterable<Message> findBySenderIdAndReceiverId(long senderId,long receiverId);

    
}
