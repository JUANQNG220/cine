package com.example.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cinema")
@NoArgsConstructor
@Getter
@Setter

public class CinemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String owner;
    private Integer capacity;
    private String name;
    private String Description;

    @ManyToOne
    @JoinColumn (name = "IdCategory")
    @JsonIgnoreProperties("cinemas")

    private CategoryModel category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema","client"})
    private List<MessageModel> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema","client"})
    private List<ReservationModel> reservations;

}

