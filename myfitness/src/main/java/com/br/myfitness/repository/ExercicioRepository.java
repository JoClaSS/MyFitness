package com.br.myfitness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.myfitness.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio,Long> {
	
	@Query(value = "SELECT * FROM exercicio e WHERE (e.treino_id = :treino_id) ORDER BY e.ordem_execucao", nativeQuery = true)
	List<Exercicio> findByTreino(@Param("treino_id") Long treinoId);

}
