package com.example.cinema.service;


import com.example.cinema.model.CinemaModel;
import com.example.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<CinemaModel> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<CinemaModel> getById(Integer id){
        return cinemaRepository.getById(id);
    }

    public CinemaModel save(CinemaModel cinemaModel){
        if(cinemaModel.getId() == null ) {
            return cinemaRepository.save(cinemaModel);
        }
        else {
            Optional<CinemaModel> optional=cinemaRepository.getById(cinemaModel.getId());
            if(optional.isEmpty()){
                return cinemaRepository.save(cinemaModel);
            } else {
                return cinemaModel;
            }
        }
    }


    public CinemaModel update(CinemaModel cinemaModel){
        if (cinemaModel.getId() != null) {
            Optional<CinemaModel> optional = cinemaRepository.getById(cinemaModel.getId());
            if (!optional.isEmpty()) {
                if (cinemaModel.getOwner() != null) {
                    optional.get().setOwner(cinemaModel.getOwner());
                }
                if (cinemaModel.getCapacity() != null) {
                    optional.get().setCapacity(cinemaModel.getCapacity());
                }
                if(cinemaModel.getName() !=null){
                    optional.get().setName(cinemaModel.getName());
                }
                if (cinemaModel.getDescription() != null) {
                    optional.get().setDescription((cinemaModel.getDescription()));
                }
                if (cinemaModel.getCategory() != null) {
                    optional.get().setCategory((cinemaModel.getCategory()));
                }
                cinemaRepository.save(optional.get());
                return optional.get();
            } else {
                return cinemaModel;
            }

        }else {
            return cinemaModel;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean = getById(id).map(box ->{
            cinemaRepository.delete(box);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
