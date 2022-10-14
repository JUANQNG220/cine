package com.example.cinema.service;

import com.example.cinema.model.ReservationModel;
import com.example.cinema.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<ReservationModel> getById(Integer id){
        return reservationRepository.getById(id);
    }

    public ReservationModel save(ReservationModel reservationModel){
        if (reservationModel.getIdReservation() == null){
            return  reservationRepository.save(reservationModel);
        }
        else{
            Optional<ReservationModel> optional=reservationRepository.getById(reservationModel.getIdReservation());
            if(optional.isEmpty()){
                return reservationRepository.save(reservationModel);
            }else {
                return reservationModel;
            }
        }
    }


    //Pendiente el update
    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getIdReservation() != null){
            Optional<ReservationModel> optional = reservationRepository.getById(reservationModel.getIdReservation());
            if (!optional.isEmpty()){
                if(reservationModel.getStartDate() != null){
                    optional.get().setStartDate(reservationModel.getStartDate());
                }
                if(reservationModel.getDevolutionDay() != null){
                    optional.get().setDevolutionDay(reservationModel.getDevolutionDay());
                }
                if(reservationModel.getStatus() != null){
                    optional.get().setStatus(reservationModel.getStatus());
                }
                reservationRepository.save(optional.get());
                return optional.get();
            }else{
                return reservationModel;
            }
        }else{
            return reservationModel;
        }
    }



    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(box->{
            reservationRepository.delete(box);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
