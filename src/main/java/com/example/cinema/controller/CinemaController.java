package com.example.cinema.controller;

import com.example.cinema.model.CinemaModel;
import com.example.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cinema")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<CinemaModel> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("/{idcinema}")
    public Optional<CinemaModel> getById(@PathVariable("idcinema")Integer id){
        return cinemaService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaModel save(@RequestBody CinemaModel cinemaModel){
        return cinemaService.save(cinemaModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaModel update (@RequestBody CinemaModel cinemaModel){
        return cinemaService.update(cinemaModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")Integer id){
        return cinemaService.delete(id);
    }

}
