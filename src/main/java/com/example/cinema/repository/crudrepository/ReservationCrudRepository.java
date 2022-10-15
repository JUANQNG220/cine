package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.ReservationModel;
import com.fasterxml.jackson.databind.DatabindException;
import org.aspectj.lang.annotation.After;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository <ReservationModel, Integer> {

    public List<ReservationModel> findAllByStatus(String status);

    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore (Date dateOne, Date dateTwo);

    @Query ("SELECT c.client, COUNT (c.client) FROM ReservationModel AS c GROUP BY c.client ORDER BY COUNT (c.client) DESC ")
    public List<Object[]> countTotalReservationsByClient();

}
