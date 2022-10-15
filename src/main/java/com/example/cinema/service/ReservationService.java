package com.example.cinema.service;

import com.example.cinema.model.ClientReport;
import com.example.cinema.model.ReservationModel;
import com.example.cinema.model.ReservationReport;
import com.example.cinema.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(!optional.isPresent()){
                return reservationRepository.save(reservationModel);
            }else {
                return reservationModel;
            }
        }
    }



    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getIdReservation() != null){
            Optional<ReservationModel> optional = reservationRepository.getById(reservationModel.getIdReservation());
            if (optional.isPresent()){
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


    public ReservationReport getReservationStatusReport(){
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("Completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationByStatus("Cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }

    public List<ReservationModel> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }

    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }

}
