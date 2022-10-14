package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <MessageModel,Integer> {
}
