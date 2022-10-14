package com.example.cinema.controller;

import com.example.cinema.model.ReservationModel;
import com.example.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{idreservation}")
    public Optional<ReservationModel> getById(@PathVariable("idreservation") Integer id){
        return reservationService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel save(@RequestBody ReservationModel reservationModel){
        return reservationService.save(reservationModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel update(@RequestBody ReservationModel reservationModel){
        return reservationService.update(reservationModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return reservationService.delete(id);
    }
}
