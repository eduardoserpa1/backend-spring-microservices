package com.microservices.backend_academico.dtos;

import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class TurmaDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private Long id_turma;
    @NotBlank
    private Long id_estudante;


}
