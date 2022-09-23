package com.microservices.backend_academico.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t1ms_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
}
