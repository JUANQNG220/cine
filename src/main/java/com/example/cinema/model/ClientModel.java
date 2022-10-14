package com.example.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
@NoArgsConstructor
@Getter
@Setter

public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")
    private List<MessageModel> messageModels;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")
    private List<ReservationModel> reservationModels;
}
