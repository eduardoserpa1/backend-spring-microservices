package com.microservices.backend_academico.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t1ms_turma")
public class TurmaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_turma;
    private Long id_estudante;
}
