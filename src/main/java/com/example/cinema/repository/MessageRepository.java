package com.example.cinema.repository;

import antlr.debug.MessageAdapter;
import com.example.cinema.model.MessageModel;
import com.example.cinema.repository.crudrepository.MessageCrudRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAll(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }

    public Optional getById(Integer id){
        return messageCrudRepository.findById(id);
    }

    public MessageModel save(MessageModel messageModel){
        return messageCrudRepository.save(messageModel);
    }

    public void delete(MessageModel messageModel){
        messageCrudRepository.delete(messageModel);
    }
}
