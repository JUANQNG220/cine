package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <ClientModel, Integer> {
}
