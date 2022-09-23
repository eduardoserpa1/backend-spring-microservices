package com.microservices.backend_academico.dtos;

import com.microservices.backend_academico.enums.Horario;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class DisciplinaDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private Horario horario;
    private Long id_turma;
}
