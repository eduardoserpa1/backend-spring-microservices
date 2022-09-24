package com.microservices.backend_academico.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.microservices.backend_academico.dtos.DisciplinaDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.services.ConsultaService;
import com.microservices.backend_academico.services.DisciplinaService;
import com.microservices.backend_academico.session.UserSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @Autowired
    UserSession userSession;

    @GetMapping ("/turmas_disciplinas")
    public ResponseEntity<Map<String,List<String>>> get_turma_disciplina_by_estudante(Long id){
        if (userSession.getAuth())
            return new ResponseEntity<>(consultaService.find_turmas_disciplinas(id), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
    }

    @GetMapping ("/estudante_turma")
    public ResponseEntity<List<EstudanteModel>> get_estudantes_by_turma(Long id){
        if (userSession.getAuth())
            return new ResponseEntity<>(consultaService.find_student_by_turma(id), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
    }

    @GetMapping ("/estudante_disciplina")
    public ResponseEntity<List<EstudanteModel>> get_estudante_by_disciplina(Long id){
        if (userSession.getAuth())
            return new ResponseEntity<>(consultaService.find_student_by_disciplina(id), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
    }

}
