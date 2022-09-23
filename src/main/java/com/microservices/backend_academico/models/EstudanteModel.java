package com.microservices.backend_academico.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t1ms_estudante")
public class EstudanteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String numero_documento;
    private String endereco;
    private String numero_matricula;

}
