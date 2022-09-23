package com.microservices.backend_academico.models;


import com.microservices.backend_academico.enums.Horario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t1ms_disciplina")
public class DisciplinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Horario horario;
    private Long id_turma;
}
