package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.CinemaModel;
import org.springframework.data.repository.CrudRepository;

public interface CinemaCrudRepository extends CrudRepository <CinemaModel, Integer> {
}
