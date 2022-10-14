package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <ReservationModel, Integer> {
}
