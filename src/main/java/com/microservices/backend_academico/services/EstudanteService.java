package com.microservices.backend_academico.services;

import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.repositories.DisciplinaRepository;
import com.microservices.backend_academico.repositories.EstudanteRepository;
import com.microservices.backend_academico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EstudanteService {
    @Autowired
    EstudanteRepository estudante_repository;

    @Autowired
    DisciplinaRepository disciplina_repository;

    @Autowired
    TurmaRepository turma_repository;

    public List<EstudanteModel> read_all(){
        return estudante_repository.findAll();
    }

    public List<EstudanteModel> read_by_matricula(String matricula){
        return estudante_repository.findAll().stream().filter(estudanteModel -> (estudanteModel.getNumero_matricula().equals(matricula))).collect(Collectors.toList());
    }

    public List<EstudanteModel> read_by_name(String nome){
        return estudante_repository.findAll().stream().filter(estudanteModel -> estudanteModel.getNome().contains(nome)).collect(Collectors.toList());
    }

    public EstudanteModel create(EstudanteModel estudante){
        Long matricula = new Random().nextLong();
        estudante.setNumero_matricula(matricula.toString());
        return estudante_repository.save(estudante);
    }

}
