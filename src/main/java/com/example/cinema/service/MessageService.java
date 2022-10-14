package com.example.cinema.service;

import com.example.cinema.model.MessageModel;
import com.example.cinema.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAll(){
        return messageRepository.getAll();
    }

    public Optional <MessageModel> getById(Integer id){
        return messageRepository.getById(id);
    }

    public MessageModel save(MessageModel messageModel){
        if(messageModel.getIdmessage() == null){
            return messageRepository.save(messageModel);
        }
        else {
            Optional<MessageModel> optional=messageRepository.getById(messageModel.getIdmessage());
            if(optional.isEmpty()){
                return messageRepository.save(messageModel);
            }else{
                return messageModel;
            }
        }
    }

    public MessageModel update(MessageModel messageModel){
        if(messageModel.getIdmessage() != null){
            Optional<MessageModel> optional = messageRepository.getById(messageModel.getIdmessage());
            if(!optional.isEmpty()){
                if(messageModel.getMessagetext() != null){
                    optional.get().setMessagetext(messageModel.getMessagetext());
                    optional.get().setClient(messageModel.getClient());
                    optional.get().setCinema(messageModel.getCinema());
                }
                messageRepository.save(optional.get());
                return optional.get();
            }else {
                return messageModel;
            }
        }else {
            return messageModel;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean =getById(id).map(box ->{
            messageRepository.delete(box);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
