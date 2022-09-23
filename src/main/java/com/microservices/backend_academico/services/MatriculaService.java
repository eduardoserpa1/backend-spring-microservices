package com.microservices.backend_academico.services;

import com.microservices.backend_academico.dtos.TurmaDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.repositories.DisciplinaRepository;
import com.microservices.backend_academico.repositories.EstudanteRepository;
import com.microservices.backend_academico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MatriculaService {
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    EstudanteRepository estudanteRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;


    public Boolean efetua_matricula(String numero_matricula, Long id_disciplina, Long id_turma){
        EstudanteModel e = estudanteRepository.find_by_numero_matricula(numero_matricula);

        if(e == null)
            return false;

        DisciplinaModel d = disciplinaRepository.find_by_ids(id_disciplina,id_turma);

        if (d == null)
            return false;

        TurmaModel t = new TurmaModel();
        t.setId_turma(id_turma);
        t.setId_estudante(e.getId());

        System.out.println(turmaRepository.save(t));

        return true;
    }
}
