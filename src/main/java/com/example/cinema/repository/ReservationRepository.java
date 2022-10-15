package com.example.cinema.repository;

import ch.qos.logback.core.net.server.Client;
import com.example.cinema.model.ClientModel;
import com.example.cinema.model.ClientReport;
import com.example.cinema.model.ReservationModel;
import com.example.cinema.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
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

    public List<ReservationModel> getReservationByStatus (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }


    public List<ClientReport> getTopClients(){
            List<ClientReport> res = new ArrayList<>();
    List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
        res.add(new ClientReport((Long) report.get(i)[1], (ClientModel) report.get(i)[0]));
    }
        return res;
    }

}

