package com.microservices.backend_academico.dtos;


import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.validation.constraints.NotBlank;


@Data
public class EstudanteDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String numero_documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String numero_matricula;
}
