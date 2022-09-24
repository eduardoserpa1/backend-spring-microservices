package com.microservices.backend_academico.services;

import com.microservices.backend_academico.exceptions.ReferenceDontExistsException;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.repositories.DisciplinaRepository;
import com.microservices.backend_academico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    TurmaRepository turmaRepository;

    public DisciplinaModel create(DisciplinaModel disciplinaModel) throws ReferenceDontExistsException{
        TurmaModel turmaModel = turmaRepository.find_by_id_turma(disciplinaModel.getId_turma());
        if (turmaModel != null)
            return disciplinaRepository.save(disciplinaModel);
        else
            throw new ReferenceDontExistsException();
    }
}
