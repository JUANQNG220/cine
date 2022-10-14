package com.example.cinema.controller;

import com.example.cinema.model.ClientModel;
import com.example.cinema.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAll(){
        return clientService.getAll();
    }

    @GetMapping("{idClient}")
    public Optional<ClientModel> getById(@PathVariable("idclient") Integer id){
        return clientService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody ClientModel clientModel){
        return clientService.save(clientModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel update(@RequestBody ClientModel clientModel){
        return clientService.update(clientModel);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")Integer id){
        return clientService.delete(id);
    }

}
