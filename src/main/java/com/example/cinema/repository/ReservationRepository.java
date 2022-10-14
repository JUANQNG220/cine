package com.example.cinema.repository;

import com.example.cinema.model.ReservationModel;
import com.example.cinema.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getById(Integer id){
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel save(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public void delete(ReservationModel reservationModel){
        reservationCrudRepository.delete(reservationModel);
    }


}
