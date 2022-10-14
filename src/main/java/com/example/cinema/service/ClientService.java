package com.example.cinema.service;

import com.example.cinema.model.ClientModel;
import com.example.cinema.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAll(){
        return clientRepository.getAll();
    }

    public Optional<ClientModel> getById(Integer id){
        return clientRepository.getById(id);
    }

    public ClientModel save(ClientModel clientModel){
        if(clientModel.getIdClient() == null){
            return clientRepository.save(clientModel);
        } else{
            Optional<ClientModel> optional=clientRepository.getById(clientModel.getIdClient());
            if(optional.isEmpty()){
                return clientRepository.save(clientModel);
            }else{
                return clientModel;
            }
        }
    }

    //pendiente update
    public ClientModel update(ClientModel clientModel){
        if(clientModel.getIdClient() != null){
            Optional<ClientModel> optional = clientRepository.getById(clientModel.getIdClient());
            if(!optional.isEmpty()){
                if(clientModel.getName()!=null){
                    optional.get().setName(clientModel.getName());
                }
                if(clientModel.getEmail()!=null){
                    optional.get().setEmail(clientModel.getEmail());
                }
                if(clientModel.getPassword()!=null){
                    optional.get().setPassword(clientModel.getPassword());
                }
                if(clientModel.getAge()!=null){
                    optional.get().setAge(clientModel.getAge());
                }
                clientRepository.save(optional.get());
                return optional.get();
            }    else {
                return clientModel;
            }
        }else {
            return clientModel;
        }
    }


    public boolean delete(Integer id){
        Boolean aBoolean = getById(id).map(box->{
            clientRepository.delete(box);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
