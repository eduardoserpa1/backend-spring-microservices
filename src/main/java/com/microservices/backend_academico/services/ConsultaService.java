package com.microservices.backend_academico.services;

import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.repositories.DisciplinaRepository;
import com.microservices.backend_academico.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    EstudanteRepository estudanteRepository;

    public Map<String,List<String>> find_turmas_disciplinas(Long id){
        HashMap<String,List<String>> response = new HashMap();

        List<DisciplinaModel> disciplinaModel = disciplinaRepository.find_by_student(id);

        if(disciplinaModel == null || disciplinaModel.isEmpty())
            return null;

        List<String> list_id_disciplina_of_student = new ArrayList<>();

        for (DisciplinaModel d:disciplinaModel)
            list_id_disciplina_of_student.add(d.getId().toString());

        response.put("disciplinas",list_id_disciplina_of_student);

        HashMap<String,String> map_id_turmas_of_student = new HashMap();

        for (DisciplinaModel d:disciplinaModel)
            map_id_turmas_of_student.put(d.getId_turma().toString(),id.toString());

        List<String> list_id_turma_of_student = new ArrayList<>();

        for (String s:map_id_turmas_of_student.keySet())
            list_id_turma_of_student.add(s);

        response.put("turmas",list_id_turma_of_student);

        return response;
    }

    public List<EstudanteModel> find_student_by_disciplina(Long id){
        return estudanteRepository.find_by_disciplina(id);
    }

    public List<EstudanteModel> find_student_by_turma(Long id){
        return estudanteRepository.find_by_turma(id);
    }


}
