package com.example.cinema.repository;

import com.example.cinema.model.CinemaModel;
import com.example.cinema.repository.crudrepository.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {

    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<CinemaModel> getAll(){
        return (List<CinemaModel>) cinemaCrudRepository.findAll();
    }

    public Optional <CinemaModel> getById(Integer id){
        return cinemaCrudRepository.findById(id);
    }

    public CinemaModel save(CinemaModel cinemaModel){
        return cinemaCrudRepository.save(cinemaModel);
    }

    public void delete(CinemaModel cinemaModel){
        cinemaCrudRepository.delete(cinemaModel);
    }

}
