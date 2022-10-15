package com.example.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.SpringVersion;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ClientReport {
    private Long total;
    private ClientModel client;
}
