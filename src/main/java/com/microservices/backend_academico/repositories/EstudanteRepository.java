package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {


    @Query("SELECT x from EstudanteModel x where x.numero_matricula like ?1")
    EstudanteModel find_by_numero_matricula(String numero_matricula);

    @Query("select e \n" +
            "from DisciplinaModel d\n" +
            "join TurmaModel t\n" +
            "on d.id_turma = t.id_turma and d.id = ?1\n" +
            "join EstudanteModel e\n" +
            "on t.id_estudante = e.id\n" +
            "group by e.id")
    List<EstudanteModel> find_by_disciplina(Long id);

    @Query("select e\n" +
            "from TurmaModel t\n" +
            "join EstudanteModel e\n" +
            "on t.id_estudante = e.id and t.id_turma = ?1\n" +
            "group by e.id")
    List<EstudanteModel> find_by_turma(Long id);
}
