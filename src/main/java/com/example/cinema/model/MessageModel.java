package com.example.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="message")
@NoArgsConstructor
@Getter
@Setter

public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="idCinema")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private CinemaModel cinema;

    //Pendiente terminar, ver video
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private ClientModel client;
}
