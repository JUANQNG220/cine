package com.example.cinema.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="message")
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idReservation;
    private Date startDate;
    private Date devolutionDay;
    private String status ="created";

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservations")
    private CinemaModel cinema;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations", "message"})
    private ClientModel client;

    private String score;
}
