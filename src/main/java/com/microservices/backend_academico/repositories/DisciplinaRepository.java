package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

    @Query("SELECT x from DisciplinaModel x where x.id = ?1 and x.id_turma = ?2")
    DisciplinaModel find_by_ids(Long id_disciplina, Long id_turma);

    @Query("select d from DisciplinaModel d where d.id_turma in (select t.id_turma from TurmaModel t join EstudanteModel e on t.id_estudante = ?1 group by t.id_turma)")
    List<DisciplinaModel> find_by_student(Long id);
}
