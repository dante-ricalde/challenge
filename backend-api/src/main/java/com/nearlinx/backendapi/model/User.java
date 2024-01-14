package com.nearlinx.backendapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "\"user\"")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

}
