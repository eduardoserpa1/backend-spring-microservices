package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.DisciplinaDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.repositories.TurmaRepository;
import com.microservices.backend_academico.services.MatriculaService;
import com.microservices.backend_academico.session.UserSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    UserSession userSession;



    @PostMapping("/cadastrar")
    public ResponseEntity<Boolean> efetuaMatricula(String numero_matricula,Long id_disciplina, Long id_turma){
        if (userSession.getAuth()){
            return new ResponseEntity<>(matriculaService.efetua_matricula(numero_matricula,id_disciplina,id_turma), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }

    }

}
